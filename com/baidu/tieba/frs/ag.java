package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ag {
    private static ag iez = new ag();
    private SparseArray<ah> iey = new SparseArray<>();

    private ag() {
    }

    public static ag cri() {
        return iez;
    }

    public ah xS(int i) {
        return this.iey.get(i);
    }
}
