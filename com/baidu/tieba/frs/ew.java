package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ew {
    private static ew bqO = new ew();
    private SparseArray<ex> bqN = new SparseArray<>();

    private ew() {
    }

    public static ew St() {
        return bqO;
    }

    public void a(int i, ex exVar) {
        this.bqN.put(i, exVar);
    }

    public ex gR(int i) {
        return this.bqN.get(i);
    }
}
