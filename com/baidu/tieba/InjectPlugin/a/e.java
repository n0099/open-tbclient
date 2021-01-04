package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes8.dex */
public class e {
    private static final e geD = new e();
    private SparseArray<d> geE = new SparseArray<>();

    private e() {
    }

    public static e bMT() {
        return geD;
    }

    public void a(int i, d dVar) {
        this.geE.put(i, dVar);
    }

    public d uo(int i) {
        return this.geE.get(i);
    }
}
