package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab dOT = new ab();
    private final SparseArray<String> dOS = new SparseArray<>();

    private ab() {
    }

    public static ab aDE() {
        return dOT;
    }

    public void mD(int i) {
        this.dOS.put(i, "1");
    }

    public boolean mE(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.dOS.get(i));
    }
}
