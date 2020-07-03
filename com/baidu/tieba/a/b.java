package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes8.dex */
public class b {
    private HashMap<Integer, Integer> eXd = new HashMap<>();

    public int pz(int i) {
        if (this.eXd != null && this.eXd.containsKey(Integer.valueOf(i))) {
            return this.eXd.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void bm(int i, int i2) {
        if (this.eXd != null) {
            this.eXd.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
