package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes14.dex */
public class c {
    private static volatile b ftx;

    public static synchronized b bDd() {
        b bVar;
        synchronized (c.class) {
            if (ftx == null) {
                ftx = new b();
            }
            bVar = ftx;
        }
        return bVar;
    }
}
