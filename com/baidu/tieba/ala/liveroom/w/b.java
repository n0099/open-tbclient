package com.baidu.tieba.ala.liveroom.w;

import com.baidu.live.data.af;
/* loaded from: classes4.dex */
public class b {
    private static volatile b hbm;
    public af blx = new af();

    public static b cbG() {
        if (hbm == null) {
            synchronized (b.class) {
                if (hbm == null) {
                    hbm = new b();
                }
            }
        }
        return hbm;
    }

    private b() {
    }
}
