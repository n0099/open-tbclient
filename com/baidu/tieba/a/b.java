package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    private HashMap<Integer, Integer> bbS = new HashMap<>();

    public int gn(int i) {
        if (this.bbS != null && this.bbS.containsKey(Integer.valueOf(i))) {
            return this.bbS.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void put(int i, int i2) {
        if (this.bbS != null) {
            this.bbS.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
