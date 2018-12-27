package com.baidu.tbadk.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class r {
    public static boolean isEMUI() {
        return s("ro.build.version.emui", "ro.build.hw_emui_api_level");
    }

    private static boolean s(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        try {
            a Qb = a.Qb();
            for (String str : strArr) {
                if (Qb.getProperty(str) != null) {
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
        private static a biI;
        private final Properties biJ = new Properties();

        private a() throws IOException {
            this.biJ.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a Qb() throws IOException {
            if (biI == null) {
                synchronized (a.class) {
                    if (biI == null) {
                        biI = new a();
                    }
                }
            }
            return biI;
        }

        public String getProperty(String str) {
            return this.biJ.getProperty(str);
        }
    }
}
