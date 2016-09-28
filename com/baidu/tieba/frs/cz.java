package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class cz {
    private static cz bTk = new cz();
    private SparseArray<da> bTj = new SparseArray<>();

    private cz() {
    }

    public static cz acy() {
        return bTk;
    }

    public void a(int i, da daVar) {
        this.bTj.put(i, daVar);
    }

    public da hZ(int i) {
        return this.bTj.get(i);
    }
}
