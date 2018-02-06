package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class aa {
    private static aa dHp = new aa();
    private SparseArray<ab> dHo = new SparseArray<>();

    private aa() {
    }

    public static aa awl() {
        return dHp;
    }

    public ab mX(int i) {
        return this.dHo.get(i);
    }
}
