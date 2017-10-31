package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ac {
    private static ac cAC = new ac();
    private final SparseArray<String> cAB = new SparseArray<>();

    private ac() {
    }

    public static ac akf() {
        return cAC;
    }

    public void jy(int i) {
        this.cAB.put(i, "1");
    }

    public boolean jz(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.cAB.get(i));
    }
}
