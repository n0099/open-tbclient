package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ad {
    private static ad dzu = new ad();
    private final SparseArray<String> dzt = new SparseArray<>();

    private ad() {
    }

    public static ad aug() {
        return dzu;
    }

    public void mY(int i) {
        this.dzt.put(i, "1");
    }

    public boolean mZ(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.dzt.get(i));
    }
}
