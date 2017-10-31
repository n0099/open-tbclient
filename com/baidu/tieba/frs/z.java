package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class z {
    private static z cAy = new z();
    private SparseArray<aa> cAx = new SparseArray<>();

    private z() {
    }

    public static z ake() {
        return cAy;
    }

    public void a(int i, aa aaVar) {
        this.cAx.put(i, aaVar);
    }

    public aa jw(int i) {
        return this.cAx.get(i);
    }
}
