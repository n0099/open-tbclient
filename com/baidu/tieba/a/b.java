package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    private HashMap<Integer, Integer> bsb = new HashMap<>();

    public int gT(int i) {
        if (this.bsb != null && this.bsb.containsKey(Integer.valueOf(i))) {
            return this.bsb.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void put(int i, int i2) {
        if (this.bsb != null) {
            this.bsb.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
