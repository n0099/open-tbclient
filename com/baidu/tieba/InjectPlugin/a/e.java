package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes8.dex */
public class e {
    private static final e eSA = new e();
    private SparseArray<d> eSB = new SparseArray<>();

    private e() {
    }

    public static e bmC() {
        return eSA;
    }

    public void a(int i, d dVar) {
        this.eSB.put(i, dVar);
    }

    public d po(int i) {
        return this.eSB.get(i);
    }
}
