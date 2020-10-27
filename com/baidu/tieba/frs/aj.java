package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class aj {
    private static aj iFW = new aj();
    private final SparseArray<String> iFV = new SparseArray<>();

    private aj() {
    }

    public static aj cxO() {
        return iFW;
    }

    public void yT(int i) {
        this.iFV.put(i, "1");
    }

    public boolean yU(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.iFV.get(i));
    }
}
