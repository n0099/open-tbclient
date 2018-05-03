package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class w {
    private static w cZY = new w();
    private SparseArray<x> cZX = new SparseArray<>();

    private w() {
    }

    public static w aqF() {
        return cZY;
    }

    public x kk(int i) {
        return this.cZX.get(i);
    }
}
