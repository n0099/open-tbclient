package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class bw {
    private static bw bSh = new bw();
    private SparseArray<bx> bSg = new SparseArray<>();

    private bw() {
    }

    public static bw abC() {
        return bSh;
    }

    public void a(int i, bx bxVar) {
        this.bSg.put(i, bxVar);
    }

    public bx ia(int i) {
        return this.bSg.get(i);
    }
}
