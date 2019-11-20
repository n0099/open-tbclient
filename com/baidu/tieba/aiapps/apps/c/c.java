package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dnu;

    public static synchronized b aGc() {
        b bVar;
        synchronized (c.class) {
            if (dnu == null) {
                dnu = new b();
            }
            bVar = dnu;
        }
        return bVar;
    }
}
