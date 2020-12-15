package com.baidu.tieba.homepage.personalize;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes22.dex */
public class g {
    private static boolean enabled = true;
    private static HashMap<String, Integer> jSy = new HashMap<>();

    public static void Mz(String str) {
        if (!TextUtils.isEmpty(str)) {
            jSy.put(str, 0);
        }
    }

    public static int cQd() {
        return jSy.size();
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean z) {
        enabled = z;
        if (!enabled) {
            jSy.clear();
        }
    }

    public static void cQe() {
        jSy.clear();
    }
}
