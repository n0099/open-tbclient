package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e bfD = new e();
    private SparseArray<d> bfE = new SparseArray<>();

    private e() {
    }

    public static e Oo() {
        return bfD;
    }

    public void a(int i, d dVar) {
        this.bfE.put(i, dVar);
    }

    public d gd(int i) {
        return this.bfE.get(i);
    }
}
