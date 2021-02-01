package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes7.dex */
public class c {
    private static volatile b gmD;

    public static synchronized b bNH() {
        b bVar;
        synchronized (c.class) {
            if (gmD == null) {
                gmD = new b();
            }
            bVar = gmD;
        }
        return bVar;
    }
}
