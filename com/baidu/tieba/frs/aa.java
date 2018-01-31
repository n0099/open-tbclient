package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class aa {
    private static aa dEm = new aa();
    private SparseArray<ab> dEl = new SparseArray<>();

    private aa() {
    }

    public static aa avn() {
        return dEm;
    }

    public ab mZ(int i) {
        return this.dEl.get(i);
    }
}
