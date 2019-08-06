package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class w {
    private static w fxZ = new w();
    private SparseArray<x> fxY = new SparseArray<>();

    private w() {
    }

    public static w bnN() {
        return fxZ;
    }

    public x rM(int i) {
        return this.fxY.get(i);
    }
}
