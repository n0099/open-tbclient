package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab ckI = new ab();
    private final SparseArray<String> ckH = new SparseArray<>();

    private ab() {
    }

    public static ab afZ() {
        return ckI;
    }

    public void iL(int i) {
        this.ckH.put(i, "1");
    }

    public boolean iM(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.ckH.get(i));
    }
}
