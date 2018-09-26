package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e bnp = new e();
    private SparseArray<d> bnq = new SparseArray<>();

    private e() {
    }

    public static e QG() {
        return bnp;
    }

    public void a(int i, d dVar) {
        this.bnq.put(i, dVar);
    }

    public d gJ(int i) {
        return this.bnq.get(i);
    }
}
