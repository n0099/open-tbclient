package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes15.dex */
public class b {
    private HashMap<Integer, Integer> fmY = new HashMap<>();

    public int rY(int i) {
        if (this.fmY != null && this.fmY.containsKey(Integer.valueOf(i))) {
            return this.fmY.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void by(int i, int i2) {
        if (this.fmY != null) {
            this.fmY.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
