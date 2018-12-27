package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab dOj = new ab();
    private final SparseArray<String> dOi = new SparseArray<>();

    private ab() {
    }

    public static ab aDh() {
        return dOj;
    }

    public void mC(int i) {
        this.dOi.put(i, "1");
    }

    public boolean mD(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.dOi.get(i));
    }
}
