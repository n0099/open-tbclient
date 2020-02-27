package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes8.dex */
public class e {
    private static final e dSW = new e();
    private SparseArray<d> dSX = new SparseArray<>();

    private e() {
    }

    public static e aVA() {
        return dSW;
    }

    public void a(int i, d dVar) {
        this.dSX.put(i, dVar);
    }

    public d nT(int i) {
        return this.dSX.get(i);
    }
}
