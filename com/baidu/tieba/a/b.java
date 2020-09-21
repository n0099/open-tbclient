package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes20.dex */
public class b {
    private HashMap<Integer, Integer> fqh = new HashMap<>();

    public int sq(int i) {
        if (this.fqh != null && this.fqh.containsKey(Integer.valueOf(i))) {
            return this.fqh.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void by(int i, int i2) {
        if (this.fqh != null) {
            this.fqh.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
