package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ad {
    private static ad dHh = new ad();
    private final SparseArray<String> dHg = new SparseArray<>();

    private ad() {
    }

    public static ad awl() {
        return dHh;
    }

    public void mZ(int i) {
        this.dHg.put(i, "1");
    }

    public boolean na(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.dHg.get(i));
    }
}
