package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class bs {
    private static bs bQX = new bs();
    private final SparseArray<String> bQW = new SparseArray<>();

    private bs() {
    }

    public static bs aac() {
        return bQX;
    }

    public void hS(int i) {
        this.bQW.put(i, "1");
    }

    public boolean hT(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.bQW.get(i));
    }
}
