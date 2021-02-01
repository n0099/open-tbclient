package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    private HashMap<Integer, Integer> gfM = new HashMap<>();

    public int sW(int i) {
        if (this.gfM != null && this.gfM.containsKey(Integer.valueOf(i))) {
            return this.gfM.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void bv(int i, int i2) {
        if (this.gfM != null) {
            this.gfM.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
