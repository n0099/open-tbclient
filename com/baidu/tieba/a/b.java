package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {
    private HashMap<Integer, Integer> cWd = new HashMap<>();

    public int mp(int i) {
        if (this.cWd != null && this.cWd.containsKey(Integer.valueOf(i))) {
            return this.cWd.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void aB(int i, int i2) {
        if (this.cWd != null) {
            this.cWd.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
