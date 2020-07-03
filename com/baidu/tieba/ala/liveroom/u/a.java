package com.baidu.tieba.ala.liveroom.u;

import com.baidu.live.data.y;
/* loaded from: classes3.dex */
public class a {
    private static volatile a grz;
    public y aZA = new y();

    public static a bJt() {
        if (grz == null) {
            synchronized (a.class) {
                if (grz == null) {
                    grz = new a();
                }
            }
        }
        return grz;
    }

    private a() {
    }
}
