package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class aa {
    private static aa grV = new aa();
    private final SparseArray<String> grU = new SparseArray<>();

    private aa() {
    }

    public static aa bFC() {
        return grV;
    }

    public void ta(int i) {
        this.grU.put(i, "1");
    }

    public boolean tb(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.grU.get(i));
    }
}
