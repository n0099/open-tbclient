package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class w {
    private static w fcp = new w();
    private SparseArray<x> fco = new SparseArray<>();

    private w() {
    }

    public static w beh() {
        return fcp;
    }

    public x ql(int i) {
        return this.fco.get(i);
    }
}
