package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    private HashMap<Integer, Integer> blD = new HashMap<>();

    public int gp(int i) {
        if (this.blD != null && this.blD.containsKey(Integer.valueOf(i))) {
            return this.blD.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void put(int i, int i2) {
        if (this.blD != null) {
            this.blD.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
