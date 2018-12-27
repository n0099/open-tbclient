package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e bvF = new e();
    private SparseArray<d> bvG = new SparseArray<>();

    private e() {
    }

    public static e TR() {
        return bvF;
    }

    public void a(int i, d dVar) {
        this.bvG.put(i, dVar);
    }

    public d hu(int i) {
        return this.bvG.get(i);
    }
}
