package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e daN = new e();
    private SparseArray<d> daO = new SparseArray<>();

    private e() {
    }

    public static e aBb() {
        return daN;
    }

    public void a(int i, d dVar) {
        this.daO.put(i, dVar);
    }

    public d lo(int i) {
        return this.daO.get(i);
    }
}
