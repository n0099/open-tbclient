package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes21.dex */
public class b {
    private HashMap<Integer, Integer> fKP = new HashMap<>();

    public int sZ(int i) {
        if (this.fKP != null && this.fKP.containsKey(Integer.valueOf(i))) {
            return this.fKP.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void by(int i, int i2) {
        if (this.fKP != null) {
            this.fKP.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
