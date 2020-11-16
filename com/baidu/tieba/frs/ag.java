package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ag {
    private static ag iMC = new ag();
    private SparseArray<ah> iMB = new SparseArray<>();

    private ag() {
    }

    public static ag czR() {
        return iMC;
    }

    public ah zC(int i) {
        return this.iMB.get(i);
    }
}
