package com.baidu.tieba.ala.liveroom.v;

import com.baidu.live.data.ak;
/* loaded from: classes4.dex */
public class b {
    private static volatile b hCn;
    public ak brJ = new ak();

    public static b ckB() {
        if (hCn == null) {
            synchronized (b.class) {
                if (hCn == null) {
                    hCn = new b();
                }
            }
        }
        return hCn;
    }

    private b() {
    }
}
