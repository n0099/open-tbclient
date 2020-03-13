package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class aa {
    private static aa gsk = new aa();
    private final SparseArray<String> gsj = new SparseArray<>();

    private aa() {
    }

    public static aa bFF() {
        return gsk;
    }

    public void ta(int i) {
        this.gsj.put(i, "1");
    }

    public boolean tb(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.gsj.get(i));
    }
}
