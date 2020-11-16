package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes20.dex */
public class e {
    private static final e fNm = new e();
    private SparseArray<d> fNn = new SparseArray<>();

    private e() {
    }

    public static e bHb() {
        return fNm;
    }

    public void a(int i, d dVar) {
        this.fNn.put(i, dVar);
    }

    public d tz(int i) {
        return this.fNn.get(i);
    }
}
