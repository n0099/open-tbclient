package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class x {
    private static x grR = new x();
    private SparseArray<y> grQ = new SparseArray<>();

    private x() {
    }

    public static x bFB() {
        return grR;
    }

    public y sY(int i) {
        return this.grQ.get(i);
    }
}
