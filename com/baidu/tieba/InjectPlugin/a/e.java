package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e bsd = new e();
    private SparseArray<d> bse = new SparseArray<>();

    private e() {
    }

    public static e SJ() {
        return bsd;
    }

    public void a(int i, d dVar) {
        this.bse.put(i, dVar);
    }

    public d hf(int i) {
        return this.bse.get(i);
    }
}
