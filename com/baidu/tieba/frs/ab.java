package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab hrg = new ab();
    private SparseArray<ac> hrf = new SparseArray<>();

    private ab() {
    }

    public static ab bWN() {
        return hrg;
    }

    public ac uf(int i) {
        return this.hrf.get(i);
    }
}
