package com.baidu.tieba.ala.liveroom.v;

import com.baidu.live.data.ak;
/* loaded from: classes4.dex */
public class b {
    private static volatile b hCl;
    public ak brJ = new ak();

    public static b ckA() {
        if (hCl == null) {
            synchronized (b.class) {
                if (hCl == null) {
                    hCl = new b();
                }
            }
        }
        return hCl;
    }

    private b() {
    }
}
