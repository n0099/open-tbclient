package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class aa {
    private static aa dHd = new aa();
    private SparseArray<ab> dHc = new SparseArray<>();

    private aa() {
    }

    public static aa awk() {
        return dHd;
    }

    public ab mX(int i) {
        return this.dHc.get(i);
    }
}
