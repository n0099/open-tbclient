package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class y {
    private static y crT = new y();
    private SparseArray<z> crS = new SparseArray<>();

    private y() {
    }

    public static y ahS() {
        return crT;
    }

    public void a(int i, z zVar) {
        this.crS.put(i, zVar);
    }

    public z iX(int i) {
        return this.crS.get(i);
    }
}
