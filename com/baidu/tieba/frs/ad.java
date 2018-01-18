package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ad {
    private static ad dDV = new ad();
    private final SparseArray<String> dDU = new SparseArray<>();

    private ad() {
    }

    public static ad avj() {
        return dDV;
    }

    public void nb(int i) {
        this.dDU.put(i, "1");
    }

    public boolean nc(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.dDU.get(i));
    }
}
