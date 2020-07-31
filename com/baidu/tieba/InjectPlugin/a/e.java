package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes15.dex */
public class e {
    private static final e eYV = new e();
    private SparseArray<d> eYW = new SparseArray<>();

    private e() {
    }

    public static e bqw() {
        return eYV;
    }

    public void a(int i, d dVar) {
        this.eYW.put(i, dVar);
    }

    public d pF(int i) {
        return this.eYW.get(i);
    }
}
