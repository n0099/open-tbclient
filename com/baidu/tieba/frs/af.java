package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class af {
    private static af iXv = new af();
    private SparseArray<ag> iXu = new SparseArray<>();

    private af() {
    }

    public static af cEi() {
        return iXv;
    }

    public ag Ah(int i) {
        return this.iXu.get(i);
    }
}
