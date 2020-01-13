package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class b {
    private HashMap<Integer, Integer> dTv = new HashMap<>();

    public int nL(int i) {
        if (this.dTv != null && this.dTv.containsKey(Integer.valueOf(i))) {
            return this.dTv.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void aY(int i, int i2) {
        if (this.dTv != null) {
            this.dTv.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
