package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes8.dex */
public class e {
    private static final e eId = new e();
    private SparseArray<d> eIe = new SparseArray<>();

    private e() {
    }

    public static e bka() {
        return eId;
    }

    public void a(int i, d dVar) {
        this.eIe.put(i, dVar);
    }

    public d oN(int i) {
        return this.eIe.get(i);
    }
}
