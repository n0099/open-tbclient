package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class x {
    private static x gmH = new x();
    private SparseArray<y> gmG = new SparseArray<>();

    private x() {
    }

    public static x bCW() {
        return gmH;
    }

    public y sN(int i) {
        return this.gmG.get(i);
    }
}
