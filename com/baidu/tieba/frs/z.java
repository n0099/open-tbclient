package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class z {
    private static z ctn = new z();
    private SparseArray<aa> ctm = new SparseArray<>();

    private z() {
    }

    public static z aib() {
        return ctn;
    }

    public void a(int i, aa aaVar) {
        this.ctm.put(i, aaVar);
    }

    public aa jh(int i) {
        return this.ctm.get(i);
    }
}
