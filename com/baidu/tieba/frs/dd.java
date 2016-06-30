package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class dd {
    private static dd bGP = new dd();
    private SparseArray<de> bGO = new SparseArray<>();

    private dd() {
    }

    public static dd WW() {
        return bGP;
    }

    public void a(int i, de deVar) {
        this.bGO.put(i, deVar);
    }

    public de ht(int i) {
        return this.bGO.get(i);
    }
}
