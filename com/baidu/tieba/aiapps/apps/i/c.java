package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes14.dex */
public class c {
    private static volatile b ftQ;

    public static synchronized b bDn() {
        b bVar;
        synchronized (c.class) {
            if (ftQ == null) {
                ftQ = new b();
            }
            bVar = ftQ;
        }
        return bVar;
    }
}
