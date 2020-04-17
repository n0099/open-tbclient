package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab hcb = new ab();
    private SparseArray<ac> hca = new SparseArray<>();

    private ab() {
    }

    public static ab bQq() {
        return hcb;
    }

    public ac ty(int i) {
        return this.hca.get(i);
    }
}
