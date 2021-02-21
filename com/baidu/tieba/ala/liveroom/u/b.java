package com.baidu.tieba.ala.liveroom.u;

import com.baidu.live.data.aq;
/* loaded from: classes11.dex */
public class b {
    private static volatile b hOu;
    public aq bvg = new aq();

    public static b ckE() {
        if (hOu == null) {
            synchronized (b.class) {
                if (hOu == null) {
                    hOu = new b();
                }
            }
        }
        return hOu;
    }

    private b() {
    }
}
