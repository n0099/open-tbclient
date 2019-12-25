package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {
    private HashMap<Integer, Integer> dTm = new HashMap<>();

    public int nL(int i) {
        if (this.dTm != null && this.dTm.containsKey(Integer.valueOf(i))) {
            return this.dTm.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void aU(int i, int i2) {
        if (this.dTm != null) {
            this.dTm.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
