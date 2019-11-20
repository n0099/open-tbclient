package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {
    private HashMap<Integer, Integer> dfB = new HashMap<>();

    public int lx(int i) {
        if (this.dfB != null && this.dfB.containsKey(Integer.valueOf(i))) {
            return this.dfB.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void aA(int i, int i2) {
        if (this.dfB != null) {
            this.dfB.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
