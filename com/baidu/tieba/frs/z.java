package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class z {
    private static z dac = new z();
    private final SparseArray<String> dab = new SparseArray<>();

    private z() {
    }

    public static z aqG() {
        return dac;
    }

    public void km(int i) {
        this.dab.put(i, "1");
    }

    public boolean kn(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.dab.get(i));
    }
}
