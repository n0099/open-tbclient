package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ac {
    private static ac cAV = new ac();
    private final SparseArray<String> cAU = new SparseArray<>();

    private ac() {
    }

    public static ac akt() {
        return cAV;
    }

    public void jx(int i) {
        this.cAU.put(i, "1");
    }

    public boolean jy(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.cAU.get(i));
    }
}
