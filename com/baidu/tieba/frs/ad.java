package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ad {
    private static ad dEq = new ad();
    private final SparseArray<String> dEp = new SparseArray<>();

    private ad() {
    }

    public static ad avo() {
        return dEq;
    }

    public void nb(int i) {
        this.dEp.put(i, "1");
    }

    public boolean nc(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.dEp.get(i));
    }
}
