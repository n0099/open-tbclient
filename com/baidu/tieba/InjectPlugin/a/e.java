package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e brr = new e();
    private SparseArray<d> brs = new SparseArray<>();

    private e() {
    }

    public static e SA() {
        return brr;
    }

    public void a(int i, d dVar) {
        this.brs.put(i, dVar);
    }

    public d gR(int i) {
        return this.brs.get(i);
    }
}
