package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ac {
    private static ac jjI = new ac();
    private SparseArray<ad> jjH = new SparseArray<>();

    private ac() {
    }

    public static ac cHe() {
        return jjI;
    }

    public ad At(int i) {
        return this.jjH.get(i);
    }
}
