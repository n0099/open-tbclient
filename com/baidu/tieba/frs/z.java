package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class z {
    private static z dbl = new z();
    private final SparseArray<String> dbk = new SparseArray<>();

    private z() {
    }

    public static z aqF() {
        return dbl;
    }

    public void kl(int i) {
        this.dbk.put(i, "1");
    }

    public boolean km(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.dbk.get(i));
    }
}
