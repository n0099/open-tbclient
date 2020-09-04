package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes15.dex */
public class b {
    private HashMap<Integer, Integer> fnc = new HashMap<>();

    public int rY(int i) {
        if (this.fnc != null && this.fnc.containsKey(Integer.valueOf(i))) {
            return this.fnc.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void by(int i, int i2) {
        if (this.fnc != null) {
            this.fnc.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
