package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class dc {
    private static dc bTo = new dc();
    private final SparseArray<String> bTn = new SparseArray<>();

    private dc() {
    }

    public static dc acz() {
        return bTo;
    }

    public void ib(int i) {
        this.bTn.put(i, "1");
    }

    public boolean ic(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.bTn.get(i));
    }
}
