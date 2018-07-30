package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class y {
    private static y dpw = new y();
    private SparseArray<z> dpv = new SparseArray<>();

    private y() {
    }

    public static y avI() {
        return dpw;
    }

    public z kF(int i) {
        return this.dpv.get(i);
    }
}
