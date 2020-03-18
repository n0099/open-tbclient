package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes8.dex */
public class e {
    private static final e dTA = new e();
    private SparseArray<d> dTB = new SparseArray<>();

    private e() {
    }

    public static e aVH() {
        return dTA;
    }

    public void a(int i, d dVar) {
        this.dTB.put(i, dVar);
    }

    public d nV(int i) {
        return this.dTB.get(i);
    }
}
