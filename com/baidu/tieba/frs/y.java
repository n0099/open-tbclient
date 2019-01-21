package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class y {
    private static y dOP = new y();
    private SparseArray<z> dOO = new SparseArray<>();

    private y() {
    }

    public static y aDD() {
        return dOP;
    }

    public z mB(int i) {
        return this.dOO.get(i);
    }
}
