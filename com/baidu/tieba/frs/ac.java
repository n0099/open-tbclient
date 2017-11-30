package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ac {
    private static ac cJZ = new ac();
    private final SparseArray<String> cJY = new SparseArray<>();

    private ac() {
    }

    public static ac amp() {
        return cJZ;
    }

    public void jV(int i) {
        this.cJY.put(i, "1");
    }

    public boolean jW(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.cJY.get(i));
    }
}
