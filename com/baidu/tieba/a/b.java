package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class b {
    private HashMap<Integer, Integer> bBh = new HashMap<>();

    public int hD(int i) {
        if (this.bBh != null && this.bBh.containsKey(Integer.valueOf(i))) {
            return this.bBh.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void put(int i, int i2) {
        if (this.bBh != null) {
            this.bBh.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
