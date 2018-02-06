package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ad {
    private static ad dHt = new ad();
    private final SparseArray<String> dHs = new SparseArray<>();

    private ad() {
    }

    public static ad awm() {
        return dHt;
    }

    public void mZ(int i) {
        this.dHs.put(i, "1");
    }

    public boolean na(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.dHs.get(i));
    }
}
