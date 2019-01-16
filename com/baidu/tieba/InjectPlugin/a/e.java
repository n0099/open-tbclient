package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e bwt = new e();
    private SparseArray<d> bwu = new SparseArray<>();

    private e() {
    }

    public static e Un() {
        return bwt;
    }

    public void a(int i, d dVar) {
        this.bwu.put(i, dVar);
    }

    public d hu(int i) {
        return this.bwu.get(i);
    }
}
