package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class w {
    private static w fsD = new w();
    private SparseArray<x> fsC = new SparseArray<>();

    private w() {
    }

    public static w blz() {
        return fsD;
    }

    public x rs(int i) {
        return this.fsC.get(i);
    }
}
