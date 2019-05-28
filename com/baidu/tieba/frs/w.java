package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class w {
    private static w fsE = new w();
    private SparseArray<x> fsD = new SparseArray<>();

    private w() {
    }

    public static w blC() {
        return fsE;
    }

    public x rs(int i) {
        return this.fsD.get(i);
    }
}
