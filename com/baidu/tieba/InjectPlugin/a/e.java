package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e cPN = new e();
    private SparseArray<d> cPO = new SparseArray<>();

    private e() {
    }

    public static e azp() {
        return cPN;
    }

    public void a(int i, d dVar) {
        this.cPO.put(i, dVar);
    }

    public d lY(int i) {
        return this.cPO.get(i);
    }
}
