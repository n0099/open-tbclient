package com.baidu.tieba.ala.liveroom.u;

import com.baidu.live.data.aq;
/* loaded from: classes10.dex */
public class b {
    private static volatile b hQd;
    public aq bwG = new aq();

    public static b ckK() {
        if (hQd == null) {
            synchronized (b.class) {
                if (hQd == null) {
                    hQd = new b();
                }
            }
        }
        return hQd;
    }

    private b() {
    }
}
