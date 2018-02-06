package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e bNH = new e();
    private SparseArray<d> bNI = new SparseArray<>();

    private e() {
    }

    public static e St() {
        return bNH;
    }

    public void a(int i, d dVar) {
        this.bNI.put(i, dVar);
    }

    public d jd(int i) {
        return this.bNI.get(i);
    }
}
