package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class dg {
    private static dg bGT = new dg();
    private final SparseArray<String> bGS = new SparseArray<>();

    private dg() {
    }

    public static dg WX() {
        return bGT;
    }

    public void hv(int i) {
        this.bGS.put(i, "1");
    }

    public boolean hw(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.bGS.get(i));
    }
}
