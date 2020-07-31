package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ah {
    private static ah hJV = new ah();
    private final SparseArray<String> hJU = new SparseArray<>();

    private ah() {
    }

    public static ah cdw() {
        return hJV;
    }

    public void ve(int i) {
        this.hJU.put(i, "1");
    }

    public boolean vf(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.hJU.get(i));
    }
}
