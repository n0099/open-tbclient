package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class bw {
    private static bw bBy = new bw();
    private SparseArray<bx> bBx = new SparseArray<>();

    private bw() {
    }

    public static bw XX() {
        return bBy;
    }

    public void a(int i, bx bxVar) {
        this.bBx.put(i, bxVar);
    }

    public bx hj(int i) {
        return this.bBx.get(i);
    }
}
