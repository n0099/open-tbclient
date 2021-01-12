package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    private HashMap<Integer, Integer> gdx = new HashMap<>();

    public int sR(int i) {
        if (this.gdx != null && this.gdx.containsKey(Integer.valueOf(i))) {
            return this.gdx.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void by(int i, int i2) {
        if (this.gdx != null) {
            this.gdx.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
