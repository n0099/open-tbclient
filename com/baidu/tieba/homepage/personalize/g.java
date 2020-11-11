package com.baidu.tieba.homepage.personalize;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes22.dex */
public class g {
    private static boolean enabled = true;
    private static HashMap<String, Integer> jDV = new HashMap<>();

    public static void LR(String str) {
        if (!TextUtils.isEmpty(str)) {
            jDV.put(str, 0);
        }
    }

    public static int cLh() {
        return jDV.size();
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean z) {
        enabled = z;
        if (!enabled) {
            jDV.clear();
        }
    }

    public static void cLi() {
        jDV.clear();
    }
}
