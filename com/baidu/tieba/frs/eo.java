package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class eo {
    private static eo blw = new eo();
    private SparseArray<ep> blv = new SparseArray<>();

    private eo() {
    }

    public static eo Qz() {
        return blw;
    }

    public void a(int i, ep epVar) {
        this.blv.put(i, epVar);
    }

    public ep gz(int i) {
        return this.blv.get(i);
    }
}
