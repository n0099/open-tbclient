package com.baidu.tbadk.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class w {
    public static boolean isEMUI() {
        return G("ro.build.version.emui", "ro.build.hw_emui_api_level");
    }

    private static boolean G(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        try {
            a bgH = a.bgH();
            for (String str : strArr) {
                if (bgH.getProperty(str) != null) {
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
        private static a evq;
        private final Properties evr = new Properties();

        private a() throws IOException {
            this.evr.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a bgH() throws IOException {
            if (evq == null) {
                synchronized (a.class) {
                    if (evq == null) {
                        evq = new a();
                    }
                }
            }
            return evq;
        }

        public String getProperty(String str) {
            return this.evr.getProperty(str);
        }
    }
}
