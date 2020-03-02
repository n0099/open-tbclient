package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes8.dex */
public class b {
    private HashMap<Integer, Integer> dXB = new HashMap<>();

    public int oc(int i) {
        if (this.dXB != null && this.dXB.containsKey(Integer.valueOf(i))) {
            return this.dXB.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void aY(int i, int i2) {
        if (this.dXB != null) {
            this.dXB.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
