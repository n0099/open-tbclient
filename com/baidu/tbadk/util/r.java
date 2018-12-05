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
            a PZ = a.PZ();
            for (String str : strArr) {
                if (PZ.getProperty(str) != null) {
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
        private static a biF;
        private final Properties biG = new Properties();

        private a() throws IOException {
            this.biG.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a PZ() throws IOException {
            if (biF == null) {
                synchronized (a.class) {
                    if (biF == null) {
                        biF = new a();
                    }
                }
            }
            return biF;
        }

        public String getProperty(String str) {
            return this.biG.getProperty(str);
        }
    }
}
