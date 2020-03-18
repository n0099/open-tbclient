package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class y {
    private static y gsQ = new y();
    private SparseArray<z> gsP = new SparseArray<>();

    private y() {
    }

    public static y bFO() {
        return gsQ;
    }

    public z ta(int i) {
        return this.gsP.get(i);
    }
}
