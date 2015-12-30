package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ed {
    private static ed biB = new ed();
    private SparseArray<ee> biA = new SparseArray<>();

    private ed() {
    }

    public static ed Ox() {
        return biB;
    }

    public void a(int i, ee eeVar) {
        this.biA.put(i, eeVar);
    }

    public ee gc(int i) {
        return this.biA.get(i);
    }
}
