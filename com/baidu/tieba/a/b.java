package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {
    private HashMap<Integer, Integer> cWW = new HashMap<>();

    public int mt(int i) {
        if (this.cWW != null && this.cWW.containsKey(Integer.valueOf(i))) {
            return this.cWW.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void aB(int i, int i2) {
        if (this.cWW != null) {
            this.cWW.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
