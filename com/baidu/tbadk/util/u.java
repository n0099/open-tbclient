package com.baidu.tbadk.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class u {
    public static boolean isEMUI() {
        return s("ro.build.version.emui", "ro.build.hw_emui_api_level");
    }

    private static boolean s(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        try {
            a aqi = a.aqi();
            for (String str : strArr) {
                if (aqi.getProperty(str) != null) {
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
        private static a ctD;
        private final Properties ctE = new Properties();

        private a() throws IOException {
            this.ctE.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a aqi() throws IOException {
            if (ctD == null) {
                synchronized (a.class) {
                    if (ctD == null) {
                        ctD = new a();
                    }
                }
            }
            return ctD;
        }

        public String getProperty(String str) {
            return this.ctE.getProperty(str);
        }
    }
}
