package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class w {
    private static w dab = new w();
    private SparseArray<x> daa = new SparseArray<>();

    private w() {
    }

    public static w aqF() {
        return dab;
    }

    public x kl(int i) {
        return this.daa.get(i);
    }
}
