package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class y {
    private static y dOf = new y();
    private SparseArray<z> dOe = new SparseArray<>();

    private y() {
    }

    public static y aDg() {
        return dOf;
    }

    public z mA(int i) {
        return this.dOe.get(i);
    }
}
