package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {
    private HashMap<Integer, Integer> cUz = new HashMap<>();

    public int mh(int i) {
        if (this.cUz != null && this.cUz.containsKey(Integer.valueOf(i))) {
            return this.cUz.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void put(int i, int i2) {
        if (this.cUz != null) {
            this.cUz.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
