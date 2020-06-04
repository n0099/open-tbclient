package com.baidu.tieba.InjectPlugin.a;

import android.util.SparseArray;
/* loaded from: classes8.dex */
public class e {
    private static final e eIo = new e();
    private SparseArray<d> eIp = new SparseArray<>();

    private e() {
    }

    public static e bkc() {
        return eIo;
    }

    public void a(int i, d dVar) {
        this.eIp.put(i, dVar);
    }

    public d oP(int i) {
        return this.eIp.get(i);
    }
}
