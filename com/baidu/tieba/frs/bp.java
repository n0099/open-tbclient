package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class bp {
    private static bp bQT = new bp();
    private SparseArray<bq> bQS = new SparseArray<>();

    private bp() {
    }

    public static bp aab() {
        return bQT;
    }

    public void a(int i, bq bqVar) {
        this.bQS.put(i, bqVar);
    }

    public bq hQ(int i) {
        return this.bQS.get(i);
    }
}
