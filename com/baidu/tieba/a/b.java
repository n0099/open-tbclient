package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes8.dex */
public class b {
    private HashMap<Integer, Integer> dXA = new HashMap<>();

    public int oc(int i) {
        if (this.dXA != null && this.dXA.containsKey(Integer.valueOf(i))) {
            return this.dXA.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void aY(int i, int i2) {
        if (this.dXA != null) {
            this.dXA.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
