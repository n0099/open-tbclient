package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ad {
    private static ad cKj = new ad();
    private final SparseArray<String> cKi = new SparseArray<>();

    private ad() {
    }

    public static ad amy() {
        return cKj;
    }

    public void jX(int i) {
        this.cKi.put(i, "1");
    }

    public boolean jY(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.cKi.get(i));
    }
}
