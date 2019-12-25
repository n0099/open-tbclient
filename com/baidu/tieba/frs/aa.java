package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class aa {
    private static aa gmL = new aa();
    private final SparseArray<String> gmK = new SparseArray<>();

    private aa() {
    }

    public static aa bCX() {
        return gmL;
    }

    public void sP(int i) {
        this.gmK.put(i, "1");
    }

    public boolean sQ(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.gmK.get(i));
    }
}
