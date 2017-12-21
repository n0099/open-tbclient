package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ad {
    private static ad cKn = new ad();
    private final SparseArray<String> cKm = new SparseArray<>();

    private ad() {
    }

    public static ad amy() {
        return cKn;
    }

    public void jX(int i) {
        this.cKm.put(i, "1");
    }

    public boolean jY(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.cKm.get(i));
    }
}
