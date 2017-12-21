package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class aa {
    private static aa cKj = new aa();
    private SparseArray<ab> cKi = new SparseArray<>();

    private aa() {
    }

    public static aa amx() {
        return cKj;
    }

    public void a(int i, ab abVar) {
        this.cKi.put(i, abVar);
    }

    public ab jV(int i) {
        return this.cKi.get(i);
    }
}
