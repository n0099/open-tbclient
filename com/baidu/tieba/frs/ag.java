package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ag {
    private static ag itw = new ag();
    private SparseArray<ah> itv = new SparseArray<>();

    private ag() {
    }

    public static ag cuG() {
        return itw;
    }

    public ah yy(int i) {
        return this.itv.get(i);
    }
}
