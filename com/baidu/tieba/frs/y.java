package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class y {
    private static y dOO = new y();
    private SparseArray<z> dON = new SparseArray<>();

    private y() {
    }

    public static y aDD() {
        return dOO;
    }

    public z mB(int i) {
        return this.dON.get(i);
    }
}
