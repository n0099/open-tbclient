package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class w {
    private static w fyk = new w();
    private SparseArray<x> fyj = new SparseArray<>();

    private w() {
    }

    public static w blA() {
        return fyk;
    }

    public x qH(int i) {
        return this.fyj.get(i);
    }
}
