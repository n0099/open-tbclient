package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class z {
    private static z daf = new z();
    private final SparseArray<String> dae = new SparseArray<>();

    private z() {
    }

    public static z aqG() {
        return daf;
    }

    public void kn(int i) {
        this.dae.put(i, "1");
    }

    public boolean ko(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.dae.get(i));
    }
}
