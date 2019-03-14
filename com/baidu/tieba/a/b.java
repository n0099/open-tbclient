package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {
    private HashMap<Integer, Integer> cMk = new HashMap<>();

    public int lt(int i) {
        if (this.cMk != null && this.cMk.containsKey(Integer.valueOf(i))) {
            return this.cMk.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void put(int i, int i2) {
        if (this.cMk != null) {
            this.cMk.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
