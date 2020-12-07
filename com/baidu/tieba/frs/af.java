package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class af {
    private static af iXt = new af();
    private SparseArray<ag> iXs = new SparseArray<>();

    private af() {
    }

    public static af cEh() {
        return iXt;
    }

    public ag Ah(int i) {
        return this.iXs.get(i);
    }
}
