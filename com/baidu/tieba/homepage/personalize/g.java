package com.baidu.tieba.homepage.personalize;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes22.dex */
public class g {
    private static boolean enabled = true;
    private static HashMap<String, Integer> jxY = new HashMap<>();

    public static void LA(String str) {
        if (!TextUtils.isEmpty(str)) {
            jxY.put(str, 0);
        }
    }

    public static int cIG() {
        return jxY.size();
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean z) {
        enabled = z;
        if (!enabled) {
            jxY.clear();
        }
    }

    public static void cIH() {
        jxY.clear();
    }
}
