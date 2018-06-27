package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class y {
    private static y dmE = new y();
    private SparseArray<z> dmD = new SparseArray<>();

    private y() {
    }

    public static y avd() {
        return dmE;
    }

    public z ku(int i) {
        return this.dmD.get(i);
    }
}
