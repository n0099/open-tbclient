package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class dq {
    private static dq aYM = new dq();
    private final SparseArray<String> aYL = new SparseArray<>();

    private dq() {
    }

    public static dq MI() {
        return aYM;
    }

    public void fP(int i) {
        this.aYL.put(i, "1");
    }

    public boolean fQ(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.aYL.get(i));
    }
}
