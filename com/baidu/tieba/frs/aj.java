package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class aj {
    private static aj iLT = new aj();
    private final SparseArray<String> iLS = new SparseArray<>();

    private aj() {
    }

    public static aj cAp() {
        return iLT;
    }

    public void zg(int i) {
        this.iLS.put(i, "1");
    }

    public boolean zh(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.iLS.get(i));
    }
}
