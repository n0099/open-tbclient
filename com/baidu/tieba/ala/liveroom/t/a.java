package com.baidu.tieba.ala.liveroom.t;

import com.baidu.live.data.x;
/* loaded from: classes3.dex */
public class a {
    private static volatile a geD;
    public x aWQ = new x();

    public static a bGm() {
        if (geD == null) {
            synchronized (a.class) {
                if (geD == null) {
                    geD = new a();
                }
            }
        }
        return geD;
    }

    private a() {
    }
}
