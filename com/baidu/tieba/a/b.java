package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {
    private HashMap<Integer, Integer> cMm = new HashMap<>();

    public int ls(int i) {
        if (this.cMm != null && this.cMm.containsKey(Integer.valueOf(i))) {
            return this.cMm.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void put(int i, int i2) {
        if (this.cMm != null) {
            this.cMm.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
