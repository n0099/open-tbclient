package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e cHE = new e();
    private SparseArray<d> cHF = new SparseArray<>();

    private e() {
    }

    public static e auj() {
        return cHE;
    }

    public void a(int i, d dVar) {
        this.cHF.put(i, dVar);
    }

    public d lj(int i) {
        return this.cHF.get(i);
    }
}
