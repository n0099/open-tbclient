package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dde;

    public static synchronized b aFn() {
        b bVar;
        synchronized (c.class) {
            if (dde == null) {
                dde = new b();
            }
            bVar = dde;
        }
        return bVar;
    }
}
