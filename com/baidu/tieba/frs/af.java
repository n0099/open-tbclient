package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class af {
    private static af jkL = new af();
    private final SparseArray<String> jkK = new SparseArray<>();

    private af() {
    }

    public static af cEz() {
        return jkL;
    }

    public void yZ(int i) {
        this.jkK.put(i, "1");
    }

    public boolean za(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.jkK.get(i));
    }
}
