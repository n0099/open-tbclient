package com.baidu.tieba.ala.liveroom.v;

import com.baidu.live.data.am;
/* loaded from: classes11.dex */
public class b {
    private static volatile b hOo;
    public am bwr = new am();

    public static b cnq() {
        if (hOo == null) {
            synchronized (b.class) {
                if (hOo == null) {
                    hOo = new b();
                }
            }
        }
        return hOo;
    }

    private b() {
    }
}
