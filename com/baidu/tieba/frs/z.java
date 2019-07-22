package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class z {
    private static z fxE = new z();
    private final SparseArray<String> fxD = new SparseArray<>();

    private z() {
    }

    public static z bnE() {
        return fxE;
    }

    public void rM(int i) {
        this.fxD.put(i, "1");
    }

    public boolean rN(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.fxD.get(i));
    }
}
