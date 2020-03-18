package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab gsU = new ab();
    private final SparseArray<String> gsT = new SparseArray<>();

    private ab() {
    }

    public static ab bFP() {
        return gsU;
    }

    public void tc(int i) {
        this.gsT.put(i, "1");
    }

    public boolean td(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.gsT.get(i));
    }
}
