package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class aj {
    private static aj hXz = new aj();
    private final SparseArray<String> hXy = new SparseArray<>();

    private aj() {
    }

    public static aj cnW() {
        return hXz;
    }

    public void xv(int i) {
        this.hXy.put(i, "1");
    }

    public boolean xw(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.hXy.get(i));
    }
}
