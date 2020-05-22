package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes8.dex */
public class b {
    private HashMap<Integer, Integer> eMG = new HashMap<>();

    public int oY(int i) {
        if (this.eMG != null && this.eMG.containsKey(Integer.valueOf(i))) {
            return this.eMG.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void bi(int i, int i2) {
        if (this.eMG != null) {
            this.eMG.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
