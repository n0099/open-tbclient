package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes8.dex */
public class e {
    private static final e gcm = new e();
    private SparseArray<d> gcn = new SparseArray<>();

    private e() {
    }

    public static e bJw() {
        return gcm;
    }

    public void a(int i, d dVar) {
        this.gcn.put(i, dVar);
    }

    public d sN(int i) {
        return this.gcn.get(i);
    }
}
