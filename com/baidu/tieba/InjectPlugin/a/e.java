package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes8.dex */
public class e {
    private static final e dSX = new e();
    private SparseArray<d> dSY = new SparseArray<>();

    private e() {
    }

    public static e aVC() {
        return dSX;
    }

    public void a(int i, d dVar) {
        this.dSY.put(i, dVar);
    }

    public d nT(int i) {
        return this.dSY.get(i);
    }
}
