package com.baidu.tieba.ala.liveroom.w;

import com.baidu.live.data.ai;
/* loaded from: classes4.dex */
public class b {
    private static volatile b hnc;
    public ai bmT = new ai();

    public static b ceK() {
        if (hnc == null) {
            synchronized (b.class) {
                if (hnc == null) {
                    hnc = new b();
                }
            }
        }
        return hnc;
    }

    private b() {
    }
}
