package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ag {
    private static ag iLP = new ag();
    private SparseArray<ah> iLO = new SparseArray<>();

    private ag() {
    }

    public static ag cAo() {
        return iLP;
    }

    public ah ze(int i) {
        return this.iLO.get(i);
    }
}
