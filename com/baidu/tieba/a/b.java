package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {
    private HashMap<Integer, Integer> dgs = new HashMap<>();

    public int ly(int i) {
        if (this.dgs != null && this.dgs.containsKey(Integer.valueOf(i))) {
            return this.dgs.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void aC(int i, int i2) {
        if (this.dgs != null) {
            this.dgs.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
