package com.baidu.tieba.homepage.personalize;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class g {
    private static boolean enabled = true;
    private static HashMap<String, Integer> kfJ = new HashMap<>();

    public static void My(String str) {
        if (!TextUtils.isEmpty(str)) {
            kfJ.put(str, 0);
        }
    }

    public static int cTk() {
        return kfJ.size();
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean z) {
        enabled = z;
        if (!enabled) {
            kfJ.clear();
        }
    }

    public static void cTl() {
        kfJ.clear();
    }
}
