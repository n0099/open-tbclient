package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e aXw = new e();
    private SparseArray<d> aXx = new SparseArray<>();

    private e() {
    }

    public static e KP() {
        return aXw;
    }

    public void a(int i, d dVar) {
        this.aXx.put(i, dVar);
    }

    public d gc(int i) {
        return this.aXx.get(i);
    }
}
