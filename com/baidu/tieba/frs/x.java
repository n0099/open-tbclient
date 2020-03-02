package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class x {
    private static x grT = new x();
    private SparseArray<y> grS = new SparseArray<>();

    private x() {
    }

    public static x bFD() {
        return grT;
    }

    public y sY(int i) {
        return this.grS.get(i);
    }
}
