package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class y {
    private static y dES = new y();
    private SparseArray<z> dER = new SparseArray<>();

    private y() {
    }

    public static y aAH() {
        return dES;
    }

    public z lX(int i) {
        return this.dER.get(i);
    }
}
