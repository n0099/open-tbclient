package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ae {
    private static ae hDT = new ae();
    private SparseArray<af> hDS = new SparseArray<>();

    private ae() {
    }

    public static ae bZX() {
        return hDT;
    }

    public af uK(int i) {
        return this.hDS.get(i);
    }
}
