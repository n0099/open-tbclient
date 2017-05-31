package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class bq {
    private static bq bWK = new bq();
    private SparseArray<br> bWJ = new SparseArray<>();

    private bq() {
    }

    public static bq abd() {
        return bWK;
    }

    public void a(int i, br brVar) {
        this.bWJ.put(i, brVar);
    }

    public br io(int i) {
        return this.bWJ.get(i);
    }
}
