package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ac {
    private static ac jmF = new ac();
    private SparseArray<ad> jmE = new SparseArray<>();

    private ac() {
    }

    public static ac cEL() {
        return jmF;
    }

    public ad yY(int i) {
        return this.jmE.get(i);
    }
}
