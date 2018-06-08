package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class z {
    private static z dkB = new z();
    private final SparseArray<String> dkA = new SparseArray<>();

    private z() {
    }

    public static z auK() {
        return dkB;
    }

    public void kq(int i) {
        this.dkA.put(i, "1");
    }

    public boolean kr(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.dkA.get(i));
    }
}
