package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class w {
    private static w dbh = new w();
    private SparseArray<x> dbg = new SparseArray<>();

    private w() {
    }

    public static w aqE() {
        return dbh;
    }

    public x kj(int i) {
        return this.dbg.get(i);
    }
}
