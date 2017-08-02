package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class y {
    private static y ckE = new y();
    private SparseArray<z> ckD = new SparseArray<>();

    private y() {
    }

    public static y afY() {
        return ckE;
    }

    public void a(int i, z zVar) {
        this.ckD.put(i, zVar);
    }

    public z iJ(int i) {
        return this.ckD.get(i);
    }
}
