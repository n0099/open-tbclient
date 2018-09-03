package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    private HashMap<Integer, Integer> bmn = new HashMap<>();

    public int gt(int i) {
        if (this.bmn != null && this.bmn.containsKey(Integer.valueOf(i))) {
            return this.bmn.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void put(int i, int i2) {
        if (this.bmn != null) {
            this.bmn.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
