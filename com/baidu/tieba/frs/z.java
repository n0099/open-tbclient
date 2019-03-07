package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class z {
    private static z fcH = new z();
    private final SparseArray<String> fcG = new SparseArray<>();

    private z() {
    }

    public static z bek() {
        return fcH;
    }

    public void qr(int i) {
        this.fcG.put(i, "1");
    }

    public boolean qs(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.fcG.get(i));
    }
}
