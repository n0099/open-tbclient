package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes15.dex */
public class e {
    private static final e fkn = new e();
    private SparseArray<d> fko = new SparseArray<>();

    private e() {
    }

    public static e bzu() {
        return fkn;
    }

    public void a(int i, d dVar) {
        this.fko.put(i, dVar);
    }

    public d rR(int i) {
        return this.fko.get(i);
    }
}
