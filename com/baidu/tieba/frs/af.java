package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class af {
    private static af jfe = new af();
    private final SparseArray<String> jfd = new SparseArray<>();

    private af() {
    }

    public static af cDn() {
        return jfe;
    }

    public void yP(int i) {
        this.jfd.put(i, "1");
    }

    public boolean yQ(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.jfd.get(i));
    }
}
