package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e aXv = new e();
    private SparseArray<d> aXw = new SparseArray<>();

    private e() {
    }

    public static e KR() {
        return aXv;
    }

    public void a(int i, d dVar) {
        this.aXw.put(i, dVar);
    }

    public d gc(int i) {
        return this.aXw.get(i);
    }
}
