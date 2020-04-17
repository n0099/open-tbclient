package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes8.dex */
public class e {
    private static final e etz = new e();
    private SparseArray<d> etA = new SparseArray<>();

    private e() {
    }

    public static e bdR() {
        return etz;
    }

    public void a(int i, d dVar) {
        this.etA.put(i, dVar);
    }

    public d oi(int i) {
        return this.etA.get(i);
    }
}
