package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class y {
    private static y dLr = new y();
    private SparseArray<z> dLq = new SparseArray<>();

    private y() {
    }

    public static y aCr() {
        return dLr;
    }

    public z mn(int i) {
        return this.dLq.get(i);
    }
}
