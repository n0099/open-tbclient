package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes4.dex */
public class c {
    private static volatile b dZk;

    public static synchronized b aXb() {
        b bVar;
        synchronized (c.class) {
            if (dZk == null) {
                dZk = new b();
            }
            bVar = dZk;
        }
        return bVar;
    }
}
