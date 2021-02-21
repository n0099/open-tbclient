package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    private HashMap<Integer, Integer> gfR = new HashMap<>();

    public int sW(int i) {
        if (this.gfR != null && this.gfR.containsKey(Integer.valueOf(i))) {
            return this.gfR.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void bv(int i, int i2) {
        if (this.gfR != null) {
            this.gfR.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
