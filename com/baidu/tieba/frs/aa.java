package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class aa {
    private static aa gpU = new aa();
    private final SparseArray<String> gpT = new SparseArray<>();

    private aa() {
    }

    public static aa bDZ() {
        return gpU;
    }

    public void sU(int i) {
        this.gpT.put(i, "1");
    }

    public boolean sV(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.gpT.get(i));
    }
}
