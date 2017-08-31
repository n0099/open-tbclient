package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab crX = new ab();
    private final SparseArray<String> crW = new SparseArray<>();

    private ab() {
    }

    public static ab ahT() {
        return crX;
    }

    public void iZ(int i) {
        this.crW.put(i, "1");
    }

    public boolean ja(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.crW.get(i));
    }
}
