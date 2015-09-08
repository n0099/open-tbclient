package com.baidu.tieba.frs;

import android.util.SparseArray;
import java.util.List;
/* loaded from: classes.dex */
public class cy {
    private static cy aYM = new cy();
    private SparseArray<List<cx>> aYL = new SparseArray<>();

    private cy() {
    }

    public static cy Mw() {
        return aYM;
    }

    public void c(int i, List<cx> list) {
        this.aYL.put(i, list);
    }

    public List<cx> fA(int i) {
        return this.aYL.get(i);
    }
}
