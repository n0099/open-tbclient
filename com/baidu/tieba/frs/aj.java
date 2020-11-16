package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class aj {
    private static aj iMG = new aj();
    private final SparseArray<String> iMF = new SparseArray<>();

    private aj() {
    }

    public static aj czS() {
        return iMG;
    }

    public void zE(int i) {
        this.iMF.put(i, "1");
    }

    public boolean zF(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.iMF.get(i));
    }
}
