package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class dn {
    private static dn aYI = new dn();
    private SparseArray<Cdo> aYH = new SparseArray<>();

    private dn() {
    }

    public static dn MH() {
        return aYI;
    }

    public void a(int i, Cdo cdo) {
        this.aYH.put(i, cdo);
    }

    public Cdo fN(int i) {
        return this.aYH.get(i);
    }
}
