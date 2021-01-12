package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ac {
    private static ac jfa = new ac();
    private SparseArray<ad> jeZ = new SparseArray<>();

    private ac() {
    }

    public static ac cDm() {
        return jfa;
    }

    public ad yN(int i) {
        return this.jeZ.get(i);
    }
}
