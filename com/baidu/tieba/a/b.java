package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class b {
    private HashMap<Integer, Integer> bAq = new HashMap<>();

    public int hC(int i) {
        if (this.bAq != null && this.bAq.containsKey(Integer.valueOf(i))) {
            return this.bAq.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void put(int i, int i2) {
        if (this.bAq != null) {
            this.bAq.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
