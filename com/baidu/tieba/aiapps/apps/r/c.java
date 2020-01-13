package com.baidu.tieba.aiapps.apps.r;
/* loaded from: classes5.dex */
public class c {
    private static volatile b ecA;

    public static synchronized b aZc() {
        b bVar;
        synchronized (c.class) {
            if (ecA == null) {
                ecA = new b();
            }
            bVar = ecA;
        }
        return bVar;
    }
}
