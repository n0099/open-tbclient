package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes21.dex */
public class b {
    private HashMap<Integer, Integer> fYz = new HashMap<>();

    public int ul(int i) {
        if (this.fYz != null && this.fYz.containsKey(Integer.valueOf(i))) {
            return this.fYz.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void bA(int i, int i2) {
        if (this.fYz != null) {
            this.fYz.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
