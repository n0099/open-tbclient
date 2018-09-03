package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class y {
    private static y dpu = new y();
    private SparseArray<z> dpt = new SparseArray<>();

    private y() {
    }

    public static y avH() {
        return dpu;
    }

    public z kE(int i) {
        return this.dpt.get(i);
    }
}
