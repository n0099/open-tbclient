package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes7.dex */
public class c {
    private static volatile b eTK;

    public static synchronized b boR() {
        b bVar;
        synchronized (c.class) {
            if (eTK == null) {
                eTK = new b();
            }
            bVar = eTK;
        }
        return bVar;
    }
}
