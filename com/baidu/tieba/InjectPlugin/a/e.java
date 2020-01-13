package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes6.dex */
public class e {
    private static final e dOQ = new e();
    private SparseArray<d> dOR = new SparseArray<>();

    private e() {
    }

    public static e aTj() {
        return dOQ;
    }

    public void a(int i, d dVar) {
        this.dOR.put(i, dVar);
    }

    public d nC(int i) {
        return this.dOR.get(i);
    }
}
