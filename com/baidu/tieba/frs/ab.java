package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab clQ = new ab();
    private final SparseArray<String> clP = new SparseArray<>();

    private ab() {
    }

    public static ab agg() {
        return clQ;
    }

    public void iL(int i) {
        this.clP.put(i, "1");
    }

    public boolean iM(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.clP.get(i));
    }
}
