package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes5.dex */
public class e {
    private static final e dOI = new e();
    private SparseArray<d> dOJ = new SparseArray<>();

    private e() {
    }

    public static e aSP() {
        return dOI;
    }

    public void a(int i, d dVar) {
        this.dOJ.put(i, dVar);
    }

    public d nC(int i) {
        return this.dOJ.get(i);
    }
}
