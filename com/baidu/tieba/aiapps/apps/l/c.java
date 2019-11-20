package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes2.dex */
public class c {
    private static volatile b drK;

    public static synchronized b aIi() {
        b bVar;
        synchronized (c.class) {
            if (drK == null) {
                drK = new b();
            }
            bVar = drK;
        }
        return bVar;
    }
}
