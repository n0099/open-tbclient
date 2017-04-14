package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class bw {
    private static bw bPQ = new bw();
    private SparseArray<bx> bPP = new SparseArray<>();

    private bw() {
    }

    public static bw aaB() {
        return bPQ;
    }

    public void a(int i, bx bxVar) {
        this.bPP.put(i, bxVar);
    }

    public bx hU(int i) {
        return this.bPP.get(i);
    }
}
