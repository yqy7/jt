plugins {
    id("java")
    id("com.vanniktech.maven.publish") version "0.36.0"
}

group = "io.github.yqy7"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()

    coordinates(group.toString(), name, version.toString())

    pom {
        name.set("jt")
        description.set("Java tools")
        inceptionYear.set("2026")
        url.set("https://github.com/yqy7/jt")
        licenses {
            license {
                name.set("The MIT License")
                url.set("https://opensource.org/licenses/MIT")
                distribution.set("repo")
            }
        }
        developers {
            developer {
                id.set("yqy7")
                name.set("yqy7")
                url.set("https://github.com/yqy7/")
            }
        }
        scm {
            url.set("https://github.com/yqy7/jt")
            connection.set("scm:git:git://github.com/yqy7/jt.git")
            developerConnection.set("scm:git:ssh://git@github.com/yqy7/jt.git")
        }
    }
}