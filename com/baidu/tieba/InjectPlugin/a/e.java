package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes21.dex */
public class e {
    private static final e fzy = new e();
    private SparseArray<d> fzz = new SparseArray<>();

    private e() {
    }

    public static e bDq() {
        return fzy;
    }

    public void a(int i, d dVar) {
        this.fzz.put(i, dVar);
    }

    public d sG(int i) {
        return this.fzz.get(i);
    }
}
