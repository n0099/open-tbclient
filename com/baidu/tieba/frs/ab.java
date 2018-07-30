package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab dpA = new ab();
    private final SparseArray<String> dpz = new SparseArray<>();

    private ab() {
    }

    public static ab avJ() {
        return dpA;
    }

    public void kH(int i) {
        this.dpz.put(i, "1");
    }

    public boolean kI(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.dpz.get(i));
    }
}
