package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class da {
    private static da aYO = new da();
    private final SparseArray<String> aYN = new SparseArray<>();

    private da() {
    }

    public static da Mx() {
        return aYO;
    }

    public void fC(int i) {
        this.aYN.put(i, "1");
    }

    public boolean fD(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.aYN.get(i));
    }
}
