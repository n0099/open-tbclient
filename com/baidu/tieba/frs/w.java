package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class w {
    private static w fcD = new w();
    private SparseArray<x> fcC = new SparseArray<>();

    private w() {
    }

    public static w bek() {
        return fcD;
    }

    public x qp(int i) {
        return this.fcC.get(i);
    }
}
