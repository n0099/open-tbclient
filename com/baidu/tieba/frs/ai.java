package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ai {
    private static ai iXz = new ai();
    private final SparseArray<String> iXy = new SparseArray<>();

    private ai() {
    }

    public static ai cEj() {
        return iXz;
    }

    public void Aj(int i) {
        this.iXy.put(i, "1");
    }

    public boolean Ak(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.iXy.get(i));
    }
}
