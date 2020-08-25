package com.baidu.tieba.ala.liveroom.w;

import com.baidu.live.data.aa;
/* loaded from: classes7.dex */
public class b {
    private static volatile b gIU;
    public aa beS = new aa();

    public static b bWx() {
        if (gIU == null) {
            synchronized (b.class) {
                if (gIU == null) {
                    gIU = new b();
                }
            }
        }
        return gIU;
    }

    private b() {
    }
}
