package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class aa {
    private static aa dDR = new aa();
    private SparseArray<ab> dDQ = new SparseArray<>();

    private aa() {
    }

    public static aa avi() {
        return dDR;
    }

    public ab mZ(int i) {
        return this.dDQ.get(i);
    }
}
