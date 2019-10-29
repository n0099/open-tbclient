package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class w {
    private static w fzb = new w();
    private SparseArray<x> fza = new SparseArray<>();

    private w() {
    }

    public static w blC() {
        return fzb;
    }

    public x qI(int i) {
        return this.fza.get(i);
    }
}
