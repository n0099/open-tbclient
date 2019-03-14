package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class z {
    private static z fcG = new z();
    private final SparseArray<String> fcF = new SparseArray<>();

    private z() {
    }

    public static z bek() {
        return fcG;
    }

    public void qr(int i) {
        this.fcF.put(i, "1");
    }

    public boolean qs(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.fcF.get(i));
    }
}
