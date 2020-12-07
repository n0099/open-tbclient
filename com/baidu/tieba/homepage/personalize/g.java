package com.baidu.tieba.homepage.personalize;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes22.dex */
public class g {
    private static boolean enabled = true;
    private static HashMap<String, Integer> jSw = new HashMap<>();

    public static void Mz(String str) {
        if (!TextUtils.isEmpty(str)) {
            jSw.put(str, 0);
        }
    }

    public static int cQc() {
        return jSw.size();
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean z) {
        enabled = z;
        if (!enabled) {
            jSw.clear();
        }
    }

    public static void cQd() {
        jSw.clear();
    }
}
