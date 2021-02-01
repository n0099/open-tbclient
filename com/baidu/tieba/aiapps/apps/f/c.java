package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes7.dex */
public class c {
    private static volatile b gmk;

    public static synchronized b bNx() {
        b bVar;
        synchronized (c.class) {
            if (gmk == null) {
                gmk = new b();
            }
            bVar = gmk;
        }
        return bVar;
    }
}
