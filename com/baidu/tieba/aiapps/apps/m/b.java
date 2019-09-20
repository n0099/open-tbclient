package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes2.dex */
public class b {
    private static volatile a djk;

    public static synchronized a aIb() {
        a aVar;
        synchronized (b.class) {
            if (djk == null) {
                djk = new a();
            }
            aVar = djk;
        }
        return aVar;
    }
}
