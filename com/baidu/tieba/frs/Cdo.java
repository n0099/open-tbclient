package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.util.SparseArray;
/* renamed from: com.baidu.tieba.frs.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo {
    private static Cdo aYA = new Cdo();
    private final SparseArray<String> aYz = new SparseArray<>();

    private Cdo() {
    }

    public static Cdo Ms() {
        return aYA;
    }

    public void fH(int i) {
        this.aYz.put(i, "1");
    }

    public boolean fI(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.aYz.get(i));
    }
}
