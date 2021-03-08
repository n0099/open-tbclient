package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes7.dex */
public class e {
    private static final e gdS = new e();
    private SparseArray<d> gdT = new SparseArray<>();

    private e() {
    }

    public static e bJF() {
        return gdS;
    }

    public void a(int i, d dVar) {
        this.gdT.put(i, dVar);
    }

    public d sP(int i) {
        return this.gdT.get(i);
    }
}
