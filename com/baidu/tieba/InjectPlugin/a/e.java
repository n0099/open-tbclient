package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e bwu = new e();
    private SparseArray<d> bwv = new SparseArray<>();

    private e() {
    }

    public static e Un() {
        return bwu;
    }

    public void a(int i, d dVar) {
        this.bwv.put(i, dVar);
    }

    public d hu(int i) {
        return this.bwv.get(i);
    }
}
