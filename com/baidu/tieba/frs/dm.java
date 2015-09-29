package com.baidu.tieba.frs;

import android.util.SparseArray;
import java.util.List;
/* loaded from: classes.dex */
public class dm {
    private static dm aYn = new dm();
    private SparseArray<List<com.baidu.tieba.frs.b.n>> aYm = new SparseArray<>();

    private dm() {
    }

    public static dm Mv() {
        return aYn;
    }

    public void c(int i, List<com.baidu.tieba.frs.b.n> list) {
        this.aYm.put(i, list);
    }

    public List<com.baidu.tieba.frs.b.n> fF(int i) {
        return this.aYm.get(i);
    }
}
