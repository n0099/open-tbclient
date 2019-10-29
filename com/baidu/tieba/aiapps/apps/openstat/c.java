package com.baidu.tieba.aiapps.apps.openstat;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dso;

    public static synchronized b aHQ() {
        b bVar;
        synchronized (c.class) {
            if (dso == null) {
                dso = new b();
            }
            bVar = dso;
        }
        return bVar;
    }
}
