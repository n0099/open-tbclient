package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    private HashMap<Integer, Integer> bmj = new HashMap<>();

    public int gu(int i) {
        if (this.bmj != null && this.bmj.containsKey(Integer.valueOf(i))) {
            return this.bmj.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void put(int i, int i2) {
        if (this.bmj != null) {
            this.bmj.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
