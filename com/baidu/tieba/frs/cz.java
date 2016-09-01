package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class cz {
    private static cz bTr = new cz();
    private SparseArray<da> bTq = new SparseArray<>();

    private cz() {
    }

    public static cz acl() {
        return bTr;
    }

    public void a(int i, da daVar) {
        this.bTq.put(i, daVar);
    }

    public da hV(int i) {
        return this.bTq.get(i);
    }
}
