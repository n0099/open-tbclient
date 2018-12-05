package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab dLv = new ab();
    private final SparseArray<String> dLu = new SparseArray<>();

    private ab() {
    }

    public static ab aCs() {
        return dLv;
    }

    public void mp(int i) {
        this.dLu.put(i, "1");
    }

    public boolean mq(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.dLu.get(i));
    }
}
