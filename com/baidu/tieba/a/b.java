package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes21.dex */
public class b {
    private HashMap<Integer, Integer> fCu = new HashMap<>();

    public int sO(int i) {
        if (this.fCu != null && this.fCu.containsKey(Integer.valueOf(i))) {
            return this.fCu.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void bx(int i, int i2) {
        if (this.fCu != null) {
            this.fCu.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
