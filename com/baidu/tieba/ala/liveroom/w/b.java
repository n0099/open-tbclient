package com.baidu.tieba.ala.liveroom.w;

import com.baidu.live.data.af;
/* loaded from: classes4.dex */
public class b {
    private static volatile b gMp;
    public af bhH = new af();

    public static b bYg() {
        if (gMp == null) {
            synchronized (b.class) {
                if (gMp == null) {
                    gMp = new b();
                }
            }
        }
        return gMp;
    }

    private b() {
    }
}
