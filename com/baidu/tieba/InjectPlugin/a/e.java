package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e dbE = new e();
    private SparseArray<d> dbF = new SparseArray<>();

    private e() {
    }

    public static e aBd() {
        return dbE;
    }

    public void a(int i, d dVar) {
        this.dbF.put(i, dVar);
    }

    public d lp(int i) {
        return this.dbF.get(i);
    }
}
