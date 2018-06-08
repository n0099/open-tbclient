package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    private HashMap<Integer, Integer> bke = new HashMap<>();

    public int go(int i) {
        if (this.bke != null && this.bke.containsKey(Integer.valueOf(i))) {
            return this.bke.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void put(int i, int i2) {
        if (this.bke != null) {
            this.bke.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
