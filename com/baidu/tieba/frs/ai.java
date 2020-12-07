package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ai {
    private static ai iXx = new ai();
    private final SparseArray<String> iXw = new SparseArray<>();

    private ai() {
    }

    public static ai cEi() {
        return iXx;
    }

    public void Aj(int i) {
        this.iXw.put(i, "1");
    }

    public boolean Ak(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.iXw.get(i));
    }
}
