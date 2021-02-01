package com.baidu.tieba.ala.liveroom.u;

import com.baidu.live.data.aq;
/* loaded from: classes11.dex */
public class b {
    private static volatile b hOg;
    public aq bvg = new aq();

    public static b ckx() {
        if (hOg == null) {
            synchronized (b.class) {
                if (hOg == null) {
                    hOg = new b();
                }
            }
        }
        return hOg;
    }

    private b() {
    }
}
