package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class af {
    private static af jkZ = new af();
    private final SparseArray<String> jkY = new SparseArray<>();

    private af() {
    }

    public static af cEG() {
        return jkZ;
    }

    public void yZ(int i) {
        this.jkY.put(i, "1");
    }

    public boolean za(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.jkY.get(i));
    }
}
