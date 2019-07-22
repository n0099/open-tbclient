package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class w {
    private static w fxA = new w();
    private SparseArray<x> fxz = new SparseArray<>();

    private w() {
    }

    public static w bnD() {
        return fxA;
    }

    public x rK(int i) {
        return this.fxz.get(i);
    }
}
