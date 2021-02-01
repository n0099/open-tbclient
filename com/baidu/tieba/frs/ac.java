package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ac {
    private static ac jkH = new ac();
    private SparseArray<ad> jkG = new SparseArray<>();

    private ac() {
    }

    public static ac cEy() {
        return jkH;
    }

    public ad yX(int i) {
        return this.jkG.get(i);
    }
}
