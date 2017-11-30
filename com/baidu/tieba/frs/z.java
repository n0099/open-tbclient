package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class z {
    private static z cJV = new z();
    private SparseArray<aa> cJU = new SparseArray<>();

    private z() {
    }

    public static z amo() {
        return cJV;
    }

    public void a(int i, aa aaVar) {
        this.cJU.put(i, aaVar);
    }

    public aa jT(int i) {
        return this.cJU.get(i);
    }
}
