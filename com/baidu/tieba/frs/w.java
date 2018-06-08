package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class w {
    private static w dkx = new w();
    private SparseArray<x> dkw = new SparseArray<>();

    private w() {
    }

    public static w auJ() {
        return dkx;
    }

    public x ko(int i) {
        return this.dkw.get(i);
    }
}
