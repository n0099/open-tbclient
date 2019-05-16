package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dbu;

    public static synchronized b aDS() {
        b bVar;
        synchronized (c.class) {
            if (dbu == null) {
                dbu = new b();
            }
            bVar = dbu;
        }
        return bVar;
    }
}
