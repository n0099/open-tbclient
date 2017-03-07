package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class bu {
    private static bu bQb = new bu();
    private SparseArray<bv> bQa = new SparseArray<>();

    private bu() {
    }

    public static bu aad() {
        return bQb;
    }

    public void a(int i, bv bvVar) {
        this.bQa.put(i, bvVar);
    }

    public bv hR(int i) {
        return this.bQa.get(i);
    }
}
