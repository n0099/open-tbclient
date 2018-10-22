package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class y {
    private static y dDC = new y();
    private SparseArray<z> dDB = new SparseArray<>();

    private y() {
    }

    public static y aBk() {
        return dDC;
    }

    public z lF(int i) {
        return this.dDB.get(i);
    }
}
