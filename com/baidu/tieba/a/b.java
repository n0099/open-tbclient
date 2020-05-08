package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes8.dex */
public class b {
    private HashMap<Integer, Integer> eyf = new HashMap<>();

    public int or(int i) {
        if (this.eyf != null && this.eyf.containsKey(Integer.valueOf(i))) {
            return this.eyf.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void bd(int i, int i2) {
        if (this.eyf != null) {
            this.eyf.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
