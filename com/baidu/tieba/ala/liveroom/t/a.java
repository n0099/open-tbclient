package com.baidu.tieba.ala.liveroom.t;

import com.baidu.live.data.x;
/* loaded from: classes3.dex */
public class a {
    private static volatile a ges;
    public x aWQ = new x();

    public static a bGk() {
        if (ges == null) {
            synchronized (a.class) {
                if (ges == null) {
                    ges = new a();
                }
            }
        }
        return ges;
    }

    private a() {
    }
}
