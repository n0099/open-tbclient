package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class b {
    private HashMap<Integer, Integer> bwT = new HashMap<>();

    public int ho(int i) {
        if (this.bwT != null && this.bwT.containsKey(Integer.valueOf(i))) {
            return this.bwT.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void put(int i, int i2) {
        if (this.bwT != null) {
            this.bwT.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
