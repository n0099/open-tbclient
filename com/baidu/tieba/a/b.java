package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes8.dex */
public class b {
    private HashMap<Integer, Integer> dXO = new HashMap<>();

    public int oc(int i) {
        if (this.dXO != null && this.dXO.containsKey(Integer.valueOf(i))) {
            return this.dXO.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void aY(int i, int i2) {
        if (this.dXO != null) {
            this.dXO.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
