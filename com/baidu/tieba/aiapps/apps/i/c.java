package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes20.dex */
public class c {
    private static volatile b gfo;

    public static synchronized b bOF() {
        b bVar;
        synchronized (c.class) {
            if (gfo == null) {
                gfo = new b();
            }
            bVar = gfo;
        }
        return bVar;
    }
}
