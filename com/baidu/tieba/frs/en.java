package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class en {
    private static en bmb = new en();
    private SparseArray<eo> bma = new SparseArray<>();

    private en() {
    }

    public static en RC() {
        return bmb;
    }

    public void a(int i, eo eoVar) {
        this.bma.put(i, eoVar);
    }

    public eo gt(int i) {
        return this.bma.get(i);
    }
}
