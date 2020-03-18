package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes8.dex */
public class b {
    private HashMap<Integer, Integer> dYe = new HashMap<>();

    public int oe(int i) {
        if (this.dYe != null && this.dYe.containsKey(Integer.valueOf(i))) {
            return this.dYe.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void aZ(int i, int i2) {
        if (this.dYe != null) {
            this.dYe.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
