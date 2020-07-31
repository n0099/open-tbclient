package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes14.dex */
public class c {
    private static volatile b fiO;

    public static synchronized b buy() {
        b bVar;
        synchronized (c.class) {
            if (fiO == null) {
                fiO = new b();
            }
            bVar = fiO;
        }
        return bVar;
    }
}
