package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class bx {
    private static bx bQf = new bx();
    private final SparseArray<String> bQe = new SparseArray<>();

    private bx() {
    }

    public static bx aae() {
        return bQf;
    }

    public void hT(int i) {
        this.bQe.put(i, "1");
    }

    public boolean hU(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.bQe.get(i));
    }
}
