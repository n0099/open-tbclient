package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class bt {
    private static bt bWO = new bt();
    private final SparseArray<String> bWN = new SparseArray<>();

    private bt() {
    }

    public static bt abe() {
        return bWO;
    }

    public void iq(int i) {
        this.bWN.put(i, "1");
    }

    public boolean ir(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.bWN.get(i));
    }
}
