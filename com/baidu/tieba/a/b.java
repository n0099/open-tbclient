package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes8.dex */
public class b {
    private HashMap<Integer, Integer> exZ = new HashMap<>();

    public int or(int i) {
        if (this.exZ != null && this.exZ.containsKey(Integer.valueOf(i))) {
            return this.exZ.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void bd(int i, int i2) {
        if (this.exZ != null) {
            this.exZ.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
