package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e cHB = new e();
    private SparseArray<d> cHC = new SparseArray<>();

    private e() {
    }

    public static e aum() {
        return cHB;
    }

    public void a(int i, d dVar) {
        this.cHC.put(i, dVar);
    }

    public d lk(int i) {
        return this.cHC.get(i);
    }
}
