package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e cPO = new e();
    private SparseArray<d> cPP = new SparseArray<>();

    private e() {
    }

    public static e azp() {
        return cPO;
    }

    public void a(int i, d dVar) {
        this.cPP.put(i, dVar);
    }

    public d lY(int i) {
        return this.cPP.get(i);
    }
}
