package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class bz {
    private static bz bPU = new bz();
    private final SparseArray<String> bPT = new SparseArray<>();

    private bz() {
    }

    public static bz aaC() {
        return bPU;
    }

    public void hW(int i) {
        this.bPT.put(i, "1");
    }

    public boolean hX(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.bPT.get(i));
    }
}
