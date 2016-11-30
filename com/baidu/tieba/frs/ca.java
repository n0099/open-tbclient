package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ca {
    private static ca bVu = new ca();
    private final SparseArray<String> bVt = new SparseArray<>();

    private ca() {
    }

    public static ca adF() {
        return bVu;
    }

    public void ia(int i) {
        this.bVt.put(i, "1");
    }

    public boolean ib(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.bVt.get(i));
    }
}
