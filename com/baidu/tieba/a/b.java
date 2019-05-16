package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {
    private HashMap<Integer, Integer> cUy = new HashMap<>();

    public int mh(int i) {
        if (this.cUy != null && this.cUy.containsKey(Integer.valueOf(i))) {
            return this.cUy.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void put(int i, int i2) {
        if (this.cUy != null) {
            this.cUy.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
