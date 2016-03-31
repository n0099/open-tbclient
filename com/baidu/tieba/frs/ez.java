package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ez {
    private static ez bqS = new ez();
    private final SparseArray<String> bqR = new SparseArray<>();

    private ez() {
    }

    public static ez Su() {
        return bqS;
    }

    public void gT(int i) {
        this.bqR.put(i, "1");
    }

    public boolean gU(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.bqR.get(i));
    }
}
