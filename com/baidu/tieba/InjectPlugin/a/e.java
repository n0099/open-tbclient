package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e bNu = new e();
    private SparseArray<d> bNv = new SparseArray<>();

    private e() {
    }

    public static e Ss() {
        return bNu;
    }

    public void a(int i, d dVar) {
        this.bNv.put(i, dVar);
    }

    public d jd(int i) {
        return this.bNv.get(i);
    }
}
