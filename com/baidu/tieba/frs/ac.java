package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes.dex */
public class ac {
    private static ac ctf = new ac();
    private final SparseArray<String> cte = new SparseArray<>();

    private ac() {
    }

    public static ac ahX() {
        return ctf;
    }

    public void ji(int i) {
        this.cte.put(i, "1");
    }

    public boolean jj(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.cte.get(i));
    }
}
