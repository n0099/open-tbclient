package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab dDG = new ab();
    private final SparseArray<String> dDF = new SparseArray<>();

    private ab() {
    }

    public static ab aBk() {
        return dDG;
    }

    public void lH(int i) {
        this.dDF.put(i, "1");
    }

    public boolean lI(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.dDF.get(i));
    }
}
