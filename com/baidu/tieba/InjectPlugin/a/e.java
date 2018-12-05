package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e bvC = new e();
    private SparseArray<d> bvD = new SparseArray<>();

    private e() {
    }

    public static e TP() {
        return bvC;
    }

    public void a(int i, d dVar) {
        this.bvD.put(i, dVar);
    }

    public d ht(int i) {
        return this.bvD.get(i);
    }
}
