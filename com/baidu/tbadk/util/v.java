package com.baidu.tbadk.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class v {
    public static boolean isEMUI() {
        return z("ro.build.version.emui", "ro.build.hw_emui_api_level");
    }

    private static boolean z(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        try {
            a aPR = a.aPR();
            for (String str : strArr) {
                if (aPR.vB(str) != null) {
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
        private static a dCD;
        private final Properties dCE = new Properties();

        private a() throws IOException {
            this.dCE.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a aPR() throws IOException {
            if (dCD == null) {
                synchronized (a.class) {
                    if (dCD == null) {
                        dCD = new a();
                    }
                }
            }
            return dCD;
        }

        public String vB(String str) {
            return this.dCE.getProperty(str);
        }
    }
}
