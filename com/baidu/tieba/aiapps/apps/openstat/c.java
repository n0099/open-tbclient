package com.baidu.tieba.aiapps.apps.openstat;
/* loaded from: classes2.dex */
public class c {
    private static volatile b diT;

    public static synchronized b aHD() {
        b bVar;
        synchronized (c.class) {
            if (diT == null) {
                diT = new b();
            }
            bVar = diT;
        }
        return bVar;
    }
}
