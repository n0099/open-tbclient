package com.baidu.tieba.ala.liveroom.v;

import com.baidu.live.data.y;
/* loaded from: classes4.dex */
public class b {
    private static volatile b gwV;
    public y aZy = new y();

    public static b bMA() {
        if (gwV == null) {
            synchronized (b.class) {
                if (gwV == null) {
                    gwV = new b();
                }
            }
        }
        return gwV;
    }

    private b() {
    }
}
