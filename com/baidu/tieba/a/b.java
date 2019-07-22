package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {
    private HashMap<Integer, Integer> cVW = new HashMap<>();

    public int mo(int i) {
        if (this.cVW != null && this.cVW.containsKey(Integer.valueOf(i))) {
            return this.cVW.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void aB(int i, int i2) {
        if (this.cVW != null) {
            this.cVW.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
