package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ac {
    private static ac jkV = new ac();
    private SparseArray<ad> jkU = new SparseArray<>();

    private ac() {
    }

    public static ac cEF() {
        return jkV;
    }

    public ad yX(int i) {
        return this.jkU.get(i);
    }
}
