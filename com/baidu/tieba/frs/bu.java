package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class bu {
    private static bu ceW = new bu();
    private final SparseArray<String> ceV = new SparseArray<>();

    private bu() {
    }

    public static bu aeV() {
        return ceW;
    }

    public void iC(int i) {
        this.ceV.put(i, "1");
    }

    public boolean iD(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.ceV.get(i));
    }
}
