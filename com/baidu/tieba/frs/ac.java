package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ac {
    private static ac ctr = new ac();
    private final SparseArray<String> ctq = new SparseArray<>();

    private ac() {
    }

    public static ac aic() {
        return ctr;
    }

    public void jj(int i) {
        this.ctq.put(i, "1");
    }

    public boolean jk(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.ctq.get(i));
    }
}
