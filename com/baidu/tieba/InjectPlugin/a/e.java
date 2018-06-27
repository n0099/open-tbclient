package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class e {
    private static final e bgR = new e();
    private SparseArray<d> bgS = new SparseArray<>();

    private e() {
    }

    public static e OH() {
        return bgR;
    }

    public void a(int i, d dVar) {
        this.bgS.put(i, dVar);
    }

    public d ge(int i) {
        return this.bgS.get(i);
    }
}
