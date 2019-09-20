package com.baidu.tieba.aiapps.apps.r;
/* loaded from: classes2.dex */
public class b {
    private static volatile a djQ;

    public static synchronized a aIs() {
        a aVar;
        synchronized (b.class) {
            if (djQ == null) {
                djQ = new a();
            }
            aVar = djQ;
        }
        return aVar;
    }
}
