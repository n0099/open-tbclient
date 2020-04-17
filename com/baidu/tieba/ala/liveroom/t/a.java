package com.baidu.tieba.ala.liveroom.t;

import com.baidu.live.data.u;
/* loaded from: classes3.dex */
public class a {
    private static volatile a fPC;
    public u aQA = new u();

    public static a bzZ() {
        if (fPC == null) {
            synchronized (a.class) {
                if (fPC == null) {
                    fPC = new a();
                }
            }
        }
        return fPC;
    }

    private a() {
    }
}
