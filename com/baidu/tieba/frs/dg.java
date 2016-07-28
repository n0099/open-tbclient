package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class dg {
    private static dg bIp = new dg();
    private final SparseArray<String> bIo = new SparseArray<>();

    private dg() {
    }

    public static dg Xp() {
        return bIp;
    }

    public void hu(int i) {
        this.bIo.put(i, "1");
    }

    public boolean hv(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.bIo.get(i));
    }
}
