package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes21.dex */
public class b {
    private HashMap<Integer, Integer> fQF = new HashMap<>();

    public int tj(int i) {
        if (this.fQF != null && this.fQF.containsKey(Integer.valueOf(i))) {
            return this.fQF.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void by(int i, int i2) {
        if (this.fQF != null) {
            this.fQF.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
