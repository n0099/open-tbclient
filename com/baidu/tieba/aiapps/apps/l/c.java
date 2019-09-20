package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dji;

    public static synchronized b aIa() {
        b bVar;
        synchronized (c.class) {
            if (dji == null) {
                dji = new b();
            }
            bVar = dji;
        }
        return bVar;
    }
}
