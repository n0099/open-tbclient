package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e bNx = new e();
    private SparseArray<d> bNy = new SparseArray<>();

    private e() {
    }

    public static e St() {
        return bNx;
    }

    public void a(int i, d dVar) {
        this.bNy.put(i, dVar);
    }

    public d jd(int i) {
        return this.bNy.get(i);
    }
}
