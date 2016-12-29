package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class bz {
    private static bz bBC = new bz();
    private final SparseArray<String> bBB = new SparseArray<>();

    private bz() {
    }

    public static bz XY() {
        return bBC;
    }

    public void hl(int i) {
        this.bBB.put(i, "1");
    }

    public boolean hm(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.bBB.get(i));
    }
}
