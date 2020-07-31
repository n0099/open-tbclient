package com.baidu.tbadk.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class w {
    public static boolean isEMUI() {
        return F("ro.build.version.emui", "ro.build.hw_emui_api_level");
    }

    private static boolean F(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        try {
            a bmP = a.bmP();
            for (String str : strArr) {
                if (bmP.getProperty(str) != null) {
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
        private static a eKS;
        private final Properties eKT = new Properties();

        private a() throws IOException {
            this.eKT.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a bmP() throws IOException {
            if (eKS == null) {
                synchronized (a.class) {
                    if (eKS == null) {
                        eKS = new a();
                    }
                }
            }
            return eKS;
        }

        public String getProperty(String str) {
            return this.eKT.getProperty(str);
        }
    }
}
