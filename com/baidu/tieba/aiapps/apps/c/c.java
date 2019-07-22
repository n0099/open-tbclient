package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dcX;

    public static synchronized b aFl() {
        b bVar;
        synchronized (c.class) {
            if (dcX == null) {
                dcX = new b();
            }
            bVar = dcX;
        }
        return bVar;
    }
}
