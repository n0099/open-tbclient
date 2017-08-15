package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class y {
    private static y cmy = new y();
    private SparseArray<z> cmx = new SparseArray<>();

    private y() {
    }

    public static y agA() {
        return cmy;
    }

    public void a(int i, z zVar) {
        this.cmx.put(i, zVar);
    }

    public z iL(int i) {
        return this.cmx.get(i);
    }
}
