package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes7.dex */
public class e {
    private static final e fZT = new e();
    private SparseArray<d> fZU = new SparseArray<>();

    private e() {
    }

    public static e bJc() {
        return fZT;
    }

    public void a(int i, d dVar) {
        this.fZU.put(i, dVar);
    }

    public d sI(int i) {
        return this.fZU.get(i);
    }
}
