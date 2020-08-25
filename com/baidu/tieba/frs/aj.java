package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes2.dex */
public class aj {
    private static aj hXt = new aj();
    private final SparseArray<String> hXs = new SparseArray<>();

    private aj() {
    }

    public static aj cnV() {
        return hXt;
    }

    public void xv(int i) {
        this.hXs.put(i, "1");
    }

    public boolean xw(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.hXs.get(i));
    }
}
