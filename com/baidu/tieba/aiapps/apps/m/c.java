package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes7.dex */
public class c {
    private static volatile b eTz;

    public static synchronized b boP() {
        b bVar;
        synchronized (c.class) {
            if (eTz == null) {
                eTz = new b();
            }
            bVar = eTz;
        }
        return bVar;
    }
}
