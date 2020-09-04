package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes15.dex */
public class e {
    private static final e fkr = new e();
    private SparseArray<d> fks = new SparseArray<>();

    private e() {
    }

    public static e bzv() {
        return fkr;
    }

    public void a(int i, d dVar) {
        this.fks.put(i, dVar);
    }

    public d rR(int i) {
        return this.fks.get(i);
    }
}
