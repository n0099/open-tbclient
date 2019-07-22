package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e cRk = new e();
    private SparseArray<d> cRl = new SparseArray<>();

    private e() {
    }

    public static e aAD() {
        return cRk;
    }

    public void a(int i, d dVar) {
        this.cRl.put(i, dVar);
    }

    public d mf(int i) {
        return this.cRl.get(i);
    }
}
