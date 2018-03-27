package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ad {
    private static ad dHm = new ad();
    private final SparseArray<String> dHl = new SparseArray<>();

    private ad() {
    }

    public static ad awn() {
        return dHm;
    }

    public void mZ(int i) {
        this.dHl.put(i, "1");
    }

    public boolean na(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.dHl.get(i));
    }
}
