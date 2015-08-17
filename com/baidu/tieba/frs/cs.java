package com.baidu.tieba.frs;

import android.util.SparseArray;
import java.util.List;
/* loaded from: classes.dex */
public class cs {
    private static cs aYv = new cs();
    private SparseArray<List<cr>> aYu = new SparseArray<>();

    private cs() {
    }

    public static cs Mx() {
        return aYv;
    }

    public void c(int i, List<cr> list) {
        this.aYu.put(i, list);
    }

    public List<cr> fs(int i) {
        return this.aYu.get(i);
    }
}
