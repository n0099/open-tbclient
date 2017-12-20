package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class aa {
    private static aa cKf = new aa();
    private SparseArray<ab> cKe = new SparseArray<>();

    private aa() {
    }

    public static aa amw() {
        return cKf;
    }

    public void a(int i, ab abVar) {
        this.cKe.put(i, abVar);
    }

    public ab jV(int i) {
        return this.cKe.get(i);
    }
}
