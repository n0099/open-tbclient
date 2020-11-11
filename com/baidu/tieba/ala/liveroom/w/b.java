package com.baidu.tieba.ala.liveroom.w;

import com.baidu.live.data.aj;
/* loaded from: classes4.dex */
public class b {
    private static volatile b hta;
    public aj bom = new aj();

    public static b chn() {
        if (hta == null) {
            synchronized (b.class) {
                if (hta == null) {
                    hta = new b();
                }
            }
        }
        return hta;
    }

    private b() {
    }
}
