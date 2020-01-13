package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes5.dex */
public class c {
    private static volatile b dZt;

    public static synchronized b aXv() {
        b bVar;
        synchronized (c.class) {
            if (dZt == null) {
                dZt = new b();
            }
            bVar = dZt;
        }
        return bVar;
    }
}
