package com.baidu.tbadk.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class r {
    public static boolean isEMUI() {
        return p("ro.build.version.emui", "ro.build.hw_emui_api_level");
    }

    private static boolean p(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        try {
            a MM = a.MM();
            for (String str : strArr) {
                if (MM.getProperty(str) != null) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {
        private static a aZP;
        private final Properties aZQ = new Properties();

        private a() throws IOException {
            this.aZQ.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a MM() throws IOException {
            if (aZP == null) {
                synchronized (a.class) {
                    if (aZP == null) {
                        aZP = new a();
                    }
                }
            }
            return aZP;
        }

        public String getProperty(String str) {
            return this.aZQ.getProperty(str);
        }
    }
}
