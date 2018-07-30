package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e bhw = new e();
    private SparseArray<d> bhx = new SparseArray<>();

    private e() {
    }

    public static e ON() {
        return bhw;
    }

    public void a(int i, d dVar) {
        this.bhx.put(i, dVar);
    }

    public d gj(int i) {
        return this.bhx.get(i);
    }
}
