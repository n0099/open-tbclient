package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes8.dex */
public class e {
    private static final e dTk = new e();
    private SparseArray<d> dTl = new SparseArray<>();

    private e() {
    }

    public static e aVD() {
        return dTk;
    }

    public void a(int i, d dVar) {
        this.dTl.put(i, dVar);
    }

    public d nT(int i) {
        return this.dTl.get(i);
    }
}
