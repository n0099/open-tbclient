package com.baidu.tbadk.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class s {
    public static boolean isEMUI() {
        return t("ro.build.version.emui", "ro.build.hw_emui_api_level");
    }

    private static boolean t(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        try {
            a Qw = a.Qw();
            for (String str : strArr) {
                if (Qw.getProperty(str) != null) {
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
        private static a bjv;
        private final Properties bjw = new Properties();

        private a() throws IOException {
            this.bjw.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a Qw() throws IOException {
            if (bjv == null) {
                synchronized (a.class) {
                    if (bjv == null) {
                        bjv = new a();
                    }
                }
            }
            return bjv;
        }

        public String getProperty(String str) {
            return this.bjw.getProperty(str);
        }
    }
}
