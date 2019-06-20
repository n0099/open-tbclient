package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {
    private HashMap<Integer, Integer> cUA = new HashMap<>();

    public int mh(int i) {
        if (this.cUA != null && this.cUA.containsKey(Integer.valueOf(i))) {
            return this.cUA.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void put(int i, int i2) {
        if (this.cUA != null) {
            this.cUA.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
