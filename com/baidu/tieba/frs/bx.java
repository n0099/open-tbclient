package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class bx {
    private static bx bVq = new bx();
    private SparseArray<by> bVp = new SparseArray<>();

    private bx() {
    }

    public static bx adE() {
        return bVq;
    }

    public void a(int i, by byVar) {
        this.bVp.put(i, byVar);
    }

    public by hY(int i) {
        return this.bVp.get(i);
    }
}
