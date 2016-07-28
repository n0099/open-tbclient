package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class dd {
    private static dd bIl = new dd();
    private SparseArray<de> bIk = new SparseArray<>();

    private dd() {
    }

    public static dd Xo() {
        return bIl;
    }

    public void a(int i, de deVar) {
        this.bIk.put(i, deVar);
    }

    public de hs(int i) {
        return this.bIk.get(i);
    }
}
