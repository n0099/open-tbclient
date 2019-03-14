package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class w {
    private static w fcC = new w();
    private SparseArray<x> fcB = new SparseArray<>();

    private w() {
    }

    public static w bej() {
        return fcC;
    }

    public x qp(int i) {
        return this.fcB.get(i);
    }
}
