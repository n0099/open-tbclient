package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e cRr = new e();
    private SparseArray<d> cRs = new SparseArray<>();

    private e() {
    }

    public static e aAF() {
        return cRr;
    }

    public void a(int i, d dVar) {
        this.cRs.put(i, dVar);
    }

    public d mg(int i) {
        return this.cRs.get(i);
    }
}
