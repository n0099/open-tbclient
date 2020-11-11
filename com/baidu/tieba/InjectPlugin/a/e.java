package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes21.dex */
public class e {
    private static final e fNJ = new e();
    private SparseArray<d> fNK = new SparseArray<>();

    private e() {
    }

    public static e bHI() {
        return fNJ;
    }

    public void a(int i, d dVar) {
        this.fNK.put(i, dVar);
    }

    public d tb(int i) {
        return this.fNK.get(i);
    }
}
