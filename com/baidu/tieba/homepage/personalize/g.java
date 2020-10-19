package com.baidu.tieba.homepage.personalize;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes22.dex */
public class g {
    private static boolean enabled = true;
    private static HashMap<String, Integer> jlB = new HashMap<>();

    public static void Lc(String str) {
        if (!TextUtils.isEmpty(str)) {
            jlB.put(str, 0);
        }
    }

    public static int cFz() {
        return jlB.size();
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean z) {
        enabled = z;
        if (!enabled) {
            jlB.clear();
        }
    }

    public static void cFA() {
        jlB.clear();
    }
}
