package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e cSk = new e();
    private SparseArray<d> cSl = new SparseArray<>();

    private e() {
    }

    public static e aAT() {
        return cSk;
    }

    public void a(int i, d dVar) {
        this.cSl.put(i, dVar);
    }

    public d mk(int i) {
        return this.cSl.get(i);
    }
}
