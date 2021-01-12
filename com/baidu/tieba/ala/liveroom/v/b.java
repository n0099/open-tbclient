package com.baidu.tieba.ala.liveroom.v;

import com.baidu.live.data.am;
/* loaded from: classes10.dex */
public class b {
    private static volatile b hJI;
    public am brD = new am();

    public static b cjy() {
        if (hJI == null) {
            synchronized (b.class) {
                if (hJI == null) {
                    hJI = new b();
                }
            }
        }
        return hJI;
    }

    private b() {
    }
}
