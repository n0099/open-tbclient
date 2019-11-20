package com.baidu.tbadk.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class t {
    public static boolean isEMUI() {
        return q("ro.build.version.emui", "ro.build.hw_emui_api_level");
    }

    private static boolean q(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        try {
            a axH = a.axH();
            for (String str : strArr) {
                if (axH.qq(str) != null) {
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
        private static a cOr;
        private final Properties cOs = new Properties();

        private a() throws IOException {
            this.cOs.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a axH() throws IOException {
            if (cOr == null) {
                synchronized (a.class) {
                    if (cOr == null) {
                        cOr = new a();
                    }
                }
            }
            return cOr;
        }

        public String qq(String str) {
            return this.cOs.getProperty(str);
        }
    }
}
