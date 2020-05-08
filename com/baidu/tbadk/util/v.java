package com.baidu.tbadk.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class v {
    public static boolean isEMUI() {
        return D("ro.build.version.emui", "ro.build.hw_emui_api_level");
    }

    private static boolean D(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        try {
            a baw = a.baw();
            for (String str : strArr) {
                if (baw.getProperty(str) != null) {
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
        private static a egY;
        private final Properties egZ = new Properties();

        private a() throws IOException {
            this.egZ.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a baw() throws IOException {
            if (egY == null) {
                synchronized (a.class) {
                    if (egY == null) {
                        egY = new a();
                    }
                }
            }
            return egY;
        }

        public String getProperty(String str) {
            return this.egZ.getProperty(str);
        }
    }
}
