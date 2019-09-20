package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class w {
    private static w fzM = new w();
    private SparseArray<x> fzL = new SparseArray<>();

    private w() {
    }

    public static w boy() {
        return fzM;
    }

    public x rP(int i) {
        return this.fzL.get(i);
    }
}
