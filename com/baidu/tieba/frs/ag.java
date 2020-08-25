package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class ag {
    private static ag hXp = new ag();
    private SparseArray<ah> hXo = new SparseArray<>();

    private ag() {
    }

    public static ag cnU() {
        return hXp;
    }

    public ah xt(int i) {
        return this.hXo.get(i);
    }
}
