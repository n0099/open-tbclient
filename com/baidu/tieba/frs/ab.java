package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab dEW = new ab();
    private final SparseArray<String> dEV = new SparseArray<>();

    private ab() {
    }

    public static ab aAI() {
        return dEW;
    }

    public void lZ(int i) {
        this.dEV.put(i, "1");
    }

    public boolean ma(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.dEV.get(i));
    }
}
