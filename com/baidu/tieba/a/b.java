package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes15.dex */
public class b {
    private HashMap<Integer, Integer> fbE = new HashMap<>();

    public int pM(int i) {
        if (this.fbE != null && this.fbE.containsKey(Integer.valueOf(i))) {
            return this.fbE.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void bp(int i, int i2) {
        if (this.fbE != null) {
            this.fbE.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
