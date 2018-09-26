package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class y {
    private static y dvB = new y();
    private SparseArray<z> dvA = new SparseArray<>();

    private y() {
    }

    public static y axO() {
        return dvB;
    }

    public z lh(int i) {
        return this.dvA.get(i);
    }
}
