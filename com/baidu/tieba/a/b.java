package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class b {
    private HashMap<Integer, Integer> bwi = new HashMap<>();

    public int hb(int i) {
        if (this.bwi != null && this.bwi.containsKey(Integer.valueOf(i))) {
            return this.bwi.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void put(int i, int i2) {
        if (this.bwi != null) {
            this.bwi.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
