package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e bhx = new e();
    private SparseArray<d> bhy = new SparseArray<>();

    private e() {
    }

    public static e OM() {
        return bhx;
    }

    public void a(int i, d dVar) {
        this.bhy.put(i, dVar);
    }

    public d gi(int i) {
        return this.bhy.get(i);
    }
}
