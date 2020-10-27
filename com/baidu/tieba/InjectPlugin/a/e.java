package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes21.dex */
public class e {
    private static final e fHT = new e();
    private SparseArray<d> fHU = new SparseArray<>();

    private e() {
    }

    public static e bFj() {
        return fHT;
    }

    public void a(int i, d dVar) {
        this.fHU.put(i, dVar);
    }

    public d sR(int i) {
        return this.fHU.get(i);
    }
}
