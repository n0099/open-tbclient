package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class aa {
    private static aa dHi = new aa();
    private SparseArray<ab> dHh = new SparseArray<>();

    private aa() {
    }

    public static aa awm() {
        return dHi;
    }

    public ab mX(int i) {
        return this.dHh.get(i);
    }
}
