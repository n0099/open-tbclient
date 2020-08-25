package com.baidu.tbadk.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes2.dex */
public final class w {
    public static boolean isEMUI() {
        return G("ro.build.version.emui", "ro.build.hw_emui_api_level");
    }

    private static boolean G(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        try {
            a bvC = a.bvC();
            for (String str : strArr) {
                if (bvC.getProperty(str) != null) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {
        private static a eVx;
        private final Properties eVy = new Properties();

        private a() throws IOException {
            this.eVy.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a bvC() throws IOException {
            if (eVx == null) {
                synchronized (a.class) {
                    if (eVx == null) {
                        eVx = new a();
                    }
                }
            }
            return eVx;
        }

        public String getProperty(String str) {
            return this.eVy.getProperty(str);
        }
    }
}
