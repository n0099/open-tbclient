package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class bx {
    private static bx bIW = new bx();
    private final SparseArray<String> bIV = new SparseArray<>();

    private bx() {
    }

    public static bx Zf() {
        return bIW;
    }

    public void hX(int i) {
        this.bIV.put(i, "1");
    }

    public boolean hY(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.bIV.get(i));
    }
}
