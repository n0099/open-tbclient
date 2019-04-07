package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e cHD = new e();
    private SparseArray<d> cHE = new SparseArray<>();

    private e() {
    }

    public static e auj() {
        return cHD;
    }

    public void a(int i, d dVar) {
        this.cHE.put(i, dVar);
    }

    public d lj(int i) {
        return this.cHE.get(i);
    }
}
