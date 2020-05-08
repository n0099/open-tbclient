package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes8.dex */
public class e {
    private static final e etE = new e();
    private SparseArray<d> etF = new SparseArray<>();

    private e() {
    }

    public static e bdP() {
        return etE;
    }

    public void a(int i, d dVar) {
        this.etF.put(i, dVar);
    }

    public d oi(int i) {
        return this.etF.get(i);
    }
}
