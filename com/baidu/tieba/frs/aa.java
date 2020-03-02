package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class aa {
    private static aa grX = new aa();
    private final SparseArray<String> grW = new SparseArray<>();

    private aa() {
    }

    public static aa bFE() {
        return grX;
    }

    public void ta(int i) {
        this.grW.put(i, "1");
    }

    public boolean tb(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.grW.get(i));
    }
}
