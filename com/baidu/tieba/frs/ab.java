package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ab {
    private static ab dOS = new ab();
    private final SparseArray<String> dOR = new SparseArray<>();

    private ab() {
    }

    public static ab aDE() {
        return dOS;
    }

    public void mD(int i) {
        this.dOR.put(i, "1");
    }

    public boolean mE(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.dOR.get(i));
    }
}
