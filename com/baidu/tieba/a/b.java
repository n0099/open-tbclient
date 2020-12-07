package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes21.dex */
public class b {
    private HashMap<Integer, Integer> fYx = new HashMap<>();

    public int ul(int i) {
        if (this.fYx != null && this.fYx.containsKey(Integer.valueOf(i))) {
            return this.fYx.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void bA(int i, int i2) {
        if (this.fYx != null) {
            this.fYx.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
