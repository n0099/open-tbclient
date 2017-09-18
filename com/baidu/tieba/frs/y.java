package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class y {
    private static y csL = new y();
    private SparseArray<z> csK = new SparseArray<>();

    private y() {
    }

    public static y aid() {
        return csL;
    }

    public void a(int i, z zVar) {
        this.csK.put(i, zVar);
    }

    public z iZ(int i) {
        return this.csK.get(i);
    }
}
