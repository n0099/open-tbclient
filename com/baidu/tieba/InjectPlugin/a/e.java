package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes20.dex */
public class e {
    private static final e fnk = new e();
    private SparseArray<d> fnl = new SparseArray<>();

    private e() {
    }

    public static e bAE() {
        return fnk;
    }

    public void a(int i, d dVar) {
        this.fnl.put(i, dVar);
    }

    public d si(int i) {
        return this.fnl.get(i);
    }
}
