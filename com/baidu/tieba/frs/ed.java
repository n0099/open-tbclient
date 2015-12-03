package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ed {
    private static ed beH = new ed();
    private SparseArray<ee> beG = new SparseArray<>();

    private ed() {
    }

    public static ed Oe() {
        return beH;
    }

    public void a(int i, ee eeVar) {
        this.beG.put(i, eeVar);
    }

    public ee gj(int i) {
        return this.beG.get(i);
    }
}
