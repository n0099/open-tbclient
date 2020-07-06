package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ah {
    private static ah hDX = new ah();
    private final SparseArray<String> hDW = new SparseArray<>();

    private ah() {
    }

    public static ah bZZ() {
        return hDX;
    }

    public void uM(int i) {
        this.hDW.put(i, "1");
    }

    public boolean uN(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.hDW.get(i));
    }
}
