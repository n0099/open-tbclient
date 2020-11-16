package com.baidu.tieba.ala.liveroom.w;

import com.baidu.live.data.aj;
/* loaded from: classes4.dex */
public class b {
    private static volatile b hsH;
    public aj bmB = new aj();

    public static b cgG() {
        if (hsH == null) {
            synchronized (b.class) {
                if (hsH == null) {
                    hsH = new b();
                }
            }
        }
        return hsH;
    }

    private b() {
    }
}
