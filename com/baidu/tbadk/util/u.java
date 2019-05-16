package com.baidu.tbadk.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class u {
    public static boolean isEMUI() {
        return r("ro.build.version.emui", "ro.build.hw_emui_api_level");
    }

    private static boolean r(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        try {
            a avj = a.avj();
            for (String str : strArr) {
                if (avj.getProperty(str) != null) {
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
        private static a cBM;
        private final Properties cBN = new Properties();

        private a() throws IOException {
            this.cBN.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a avj() throws IOException {
            if (cBM == null) {
                synchronized (a.class) {
                    if (cBM == null) {
                        cBM = new a();
                    }
                }
            }
            return cBM;
        }

        public String getProperty(String str) {
            return this.cBN.getProperty(str);
        }
    }
}
