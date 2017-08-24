package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class y {
    private static y cmz = new y();
    private SparseArray<z> cmy = new SparseArray<>();

    private y() {
    }

    public static y agu() {
        return cmz;
    }

    public void a(int i, z zVar) {
        this.cmy.put(i, zVar);
    }

    public z iL(int i) {
        return this.cmy.get(i);
    }
}
