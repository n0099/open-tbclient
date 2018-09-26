package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab dvF = new ab();
    private final SparseArray<String> dvE = new SparseArray<>();

    private ab() {
    }

    public static ab axP() {
        return dvF;
    }

    public void lj(int i) {
        this.dvE.put(i, "1");
    }

    public boolean lk(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.dvE.get(i));
    }
}
