package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ag {
    private static ag hXv = new ag();
    private SparseArray<ah> hXu = new SparseArray<>();

    private ag() {
    }

    public static ag cnV() {
        return hXv;
    }

    public ah xt(int i) {
        return this.hXu.get(i);
    }
}
