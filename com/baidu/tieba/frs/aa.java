package com.baidu.tieba.frs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class aa {
    private static aa dzq = new aa();
    private SparseArray<ab> dzp = new SparseArray<>();

    private aa() {
    }

    public static aa auf() {
        return dzq;
    }

    public ab mW(int i) {
        return this.dzp.get(i);
    }
}
