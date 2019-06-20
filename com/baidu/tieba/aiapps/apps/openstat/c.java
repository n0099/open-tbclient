package com.baidu.tieba.aiapps.apps.openstat;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dfy;

    public static synchronized b aFB() {
        b bVar;
        synchronized (c.class) {
            if (dfy == null) {
                dfy = new b();
            }
            bVar = dfy;
        }
        return bVar;
    }
}
