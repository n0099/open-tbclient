package com.baidu.tieba.ala.liveroom.w;

import com.baidu.live.data.aa;
/* loaded from: classes7.dex */
public class b {
    private static volatile b gIY;
    public aa beU = new aa();

    public static b bWy() {
        if (gIY == null) {
            synchronized (b.class) {
                if (gIY == null) {
                    gIY = new b();
                }
            }
        }
        return gIY;
    }

    private b() {
    }
}
