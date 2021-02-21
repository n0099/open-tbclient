package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes8.dex */
public class e {
    private static final e gcr = new e();
    private SparseArray<d> gcs = new SparseArray<>();

    private e() {
    }

    public static e bJB() {
        return gcr;
    }

    public void a(int i, d dVar) {
        this.gcs.put(i, dVar);
    }

    public d sN(int i) {
        return this.gcs.get(i);
    }
}
