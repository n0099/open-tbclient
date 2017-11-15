package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class z {
    private static z cAR = new z();
    private SparseArray<aa> cAQ = new SparseArray<>();

    private z() {
    }

    public static z aks() {
        return cAR;
    }

    public void a(int i, aa aaVar) {
        this.cAQ.put(i, aaVar);
    }

    public aa jv(int i) {
        return this.cAQ.get(i);
    }
}
