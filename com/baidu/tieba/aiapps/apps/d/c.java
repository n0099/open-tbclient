package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dbv;

    public static synchronized b aDV() {
        b bVar;
        synchronized (c.class) {
            if (dbv == null) {
                dbv = new b();
            }
            bVar = dbv;
        }
        return bVar;
    }
}
