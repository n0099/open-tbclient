package com.baidu.tieba.ala.liveroom.t;

import com.baidu.live.data.u;
/* loaded from: classes3.dex */
public class a {
    private static volatile a fPH;
    public u aQF = new u();

    public static a bzX() {
        if (fPH == null) {
            synchronized (a.class) {
                if (fPH == null) {
                    fPH = new a();
                }
            }
        }
        return fPH;
    }

    private a() {
    }
}
