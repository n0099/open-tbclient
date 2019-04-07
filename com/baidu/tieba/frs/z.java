package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class z {
    private static z fct = new z();
    private final SparseArray<String> fcs = new SparseArray<>();

    private z() {
    }

    public static z bei() {
        return fct;
    }

    public void qn(int i) {
        this.fcs.put(i, "1");
    }

    public boolean qo(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.fcs.get(i));
    }
}
