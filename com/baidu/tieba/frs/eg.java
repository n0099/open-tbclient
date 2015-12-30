package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class eg {
    private static eg biF = new eg();
    private final SparseArray<String> biE = new SparseArray<>();

    private eg() {
    }

    public static eg Oy() {
        return biF;
    }

    public void ge(int i) {
        this.biE.put(i, "1");
    }

    public boolean gf(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.biE.get(i));
    }
}
