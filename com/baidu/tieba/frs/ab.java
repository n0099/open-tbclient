package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab hqV = new ab();
    private SparseArray<ac> hqU = new SparseArray<>();

    private ab() {
    }

    public static ab bWL() {
        return hqV;
    }

    public ac ud(int i) {
        return this.hqU.get(i);
    }
}
