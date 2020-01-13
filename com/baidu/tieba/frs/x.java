package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class x {
    private static x gpQ = new x();
    private SparseArray<y> gpP = new SparseArray<>();

    private x() {
    }

    public static x bDY() {
        return gpQ;
    }

    public y sS(int i) {
        return this.gpP.get(i);
    }
}
