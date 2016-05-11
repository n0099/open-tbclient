package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class eq {
    private static eq bmf = new eq();
    private final SparseArray<String> bme = new SparseArray<>();

    private eq() {
    }

    public static eq RD() {
        return bmf;
    }

    public void gv(int i) {
        this.bme.put(i, "1");
    }

    public boolean gw(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.bme.get(i));
    }
}
