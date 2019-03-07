package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {
    private HashMap<Integer, Integer> cMn = new HashMap<>();

    public int lt(int i) {
        if (this.cMn != null && this.cMn.containsKey(Integer.valueOf(i))) {
            return this.cMn.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void put(int i, int i2) {
        if (this.cMn != null) {
            this.cMn.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
