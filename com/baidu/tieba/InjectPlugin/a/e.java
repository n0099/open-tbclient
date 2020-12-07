package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes21.dex */
public class e {
    private static final e fUX = new e();
    private SparseArray<d> fUY = new SparseArray<>();

    private e() {
    }

    public static e bKB() {
        return fUX;
    }

    public void a(int i, d dVar) {
        this.fUY.put(i, dVar);
    }

    public d uc(int i) {
        return this.fUY.get(i);
    }
}
