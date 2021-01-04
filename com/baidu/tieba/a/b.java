package com.baidu.tieba.a;

import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    private HashMap<Integer, Integer> gig = new HashMap<>();

    public int ux(int i) {
        if (this.gig != null && this.gig.containsKey(Integer.valueOf(i))) {
            return this.gig.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void by(int i, int i2) {
        if (this.gig != null) {
            this.gig.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
