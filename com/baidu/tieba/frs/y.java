package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class y {
    private static y clM = new y();
    private SparseArray<z> clL = new SparseArray<>();

    private y() {
    }

    public static y agf() {
        return clM;
    }

    public void a(int i, z zVar) {
        this.clL.put(i, zVar);
    }

    public z iJ(int i) {
        return this.clL.get(i);
    }
}
