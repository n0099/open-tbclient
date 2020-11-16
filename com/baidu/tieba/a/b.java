package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes20.dex */
public class b {
    private HashMap<Integer, Integer> fQo = new HashMap<>();

    public int tH(int i) {
        if (this.fQo != null && this.fQo.containsKey(Integer.valueOf(i))) {
            return this.fQo.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void by(int i, int i2) {
        if (this.fQo != null) {
            this.fQo.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
