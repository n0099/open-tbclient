package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    private HashMap<Integer, Integer> bbR = new HashMap<>();

    public int gn(int i) {
        if (this.bbR != null && this.bbR.containsKey(Integer.valueOf(i))) {
            return this.bbR.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void put(int i, int i2) {
        if (this.bbR != null) {
            this.bbR.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
