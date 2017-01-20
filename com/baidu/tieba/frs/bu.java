package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class bu {
    private static bu bIS = new bu();
    private SparseArray<bv> bIR = new SparseArray<>();

    private bu() {
    }

    public static bu Ze() {
        return bIS;
    }

    public void a(int i, bv bvVar) {
        this.bIR.put(i, bvVar);
    }

    public bv hV(int i) {
        return this.bIR.get(i);
    }
}
