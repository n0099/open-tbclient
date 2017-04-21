package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class bz {
    private static bz bSl = new bz();
    private final SparseArray<String> bSk = new SparseArray<>();

    private bz() {
    }

    public static bz abD() {
        return bSl;
    }

    public void ic(int i) {
        this.bSk.put(i, "1");
    }

    public boolean id(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.bSk.get(i));
    }
}
