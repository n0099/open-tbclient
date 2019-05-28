package com.baidu.tieba.aiapps.apps.openstat;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dfx;

    public static synchronized b aFB() {
        b bVar;
        synchronized (c.class) {
            if (dfx == null) {
                dfx = new b();
            }
            bVar = dfx;
        }
        return bVar;
    }
}
