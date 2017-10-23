package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class z {
    private static z ctb = new z();
    private SparseArray<aa> cta = new SparseArray<>();

    private z() {
    }

    public static z ahW() {
        return ctb;
    }

    public void a(int i, aa aaVar) {
        this.cta.put(i, aaVar);
    }

    public aa jg(int i) {
        return this.cta.get(i);
    }
}
