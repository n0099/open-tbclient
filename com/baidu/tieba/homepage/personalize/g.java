package com.baidu.tieba.homepage.personalize;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes21.dex */
public class g {
    private static boolean enabled = true;
    private static HashMap<String, Integer> jET = new HashMap<>();

    public static void Ls(String str) {
        if (!TextUtils.isEmpty(str)) {
            jET.put(str, 0);
        }
    }

    public static int cKN() {
        return jET.size();
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean z) {
        enabled = z;
        if (!enabled) {
            jET.clear();
        }
    }

    public static void cKO() {
        jET.clear();
    }
}
