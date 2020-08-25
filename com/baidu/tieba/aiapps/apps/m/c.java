package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes14.dex */
public class c {
    private static volatile b fuk;

    public static synchronized b bDt() {
        b bVar;
        synchronized (c.class) {
            if (fuk == null) {
                fuk = new b();
            }
            bVar = fuk;
        }
        return bVar;
    }
}
