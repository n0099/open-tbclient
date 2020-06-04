package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes8.dex */
public class b {
    private HashMap<Integer, Integer> eMR = new HashMap<>();

    public int pa(int i) {
        if (this.eMR != null && this.eMR.containsKey(Integer.valueOf(i))) {
            return this.eMR.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void bi(int i, int i2) {
        if (this.eMR != null) {
            this.eMR.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
