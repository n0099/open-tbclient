package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    private HashMap<Integer, Integer> ghu = new HashMap<>();

    public int sY(int i) {
        if (this.ghu != null && this.ghu.containsKey(Integer.valueOf(i))) {
            return this.ghu.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void bv(int i, int i2) {
        if (this.ghu != null) {
            this.ghu.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
