package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class x {
    private static x gsg = new x();
    private SparseArray<y> gsf = new SparseArray<>();

    private x() {
    }

    public static x bFE() {
        return gsg;
    }

    public y sY(int i) {
        return this.gsf.get(i);
    }
}
