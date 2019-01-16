package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class b {
    private HashMap<Integer, Integer> bBg = new HashMap<>();

    public int hD(int i) {
        if (this.bBg != null && this.bBg.containsKey(Integer.valueOf(i))) {
            return this.bBg.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void put(int i, int i2) {
        if (this.bBg != null) {
            this.bBg.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
