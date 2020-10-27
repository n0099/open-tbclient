package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ag {
    private static ag iFS = new ag();
    private SparseArray<ah> iFR = new SparseArray<>();

    private ag() {
    }

    public static ag cxN() {
        return iFS;
    }

    public ah yR(int i) {
        return this.iFR.get(i);
    }
}
