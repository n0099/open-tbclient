package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class af {
    private static af jmJ = new af();
    private final SparseArray<String> jmI = new SparseArray<>();

    private af() {
    }

    public static af cEM() {
        return jmJ;
    }

    public void za(int i) {
        this.jmI.put(i, "1");
    }

    public boolean zb(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.jmI.get(i));
    }
}
