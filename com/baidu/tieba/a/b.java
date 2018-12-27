package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class b {
    private HashMap<Integer, Integer> bAt = new HashMap<>();

    public int hD(int i) {
        if (this.bAt != null && this.bAt.containsKey(Integer.valueOf(i))) {
            return this.bAt.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void put(int i, int i2) {
        if (this.bAt != null) {
            this.bAt.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
