package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab hch = new ab();
    private SparseArray<ac> hcg = new SparseArray<>();

    private ab() {
    }

    public static ab bQp() {
        return hch;
    }

    public ac ty(int i) {
        return this.hcg.get(i);
    }
}
