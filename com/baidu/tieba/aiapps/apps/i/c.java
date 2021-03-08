package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes6.dex */
public class c {
    private static volatile b goA;

    public static synchronized b bNU() {
        b bVar;
        synchronized (c.class) {
            if (goA == null) {
                goA = new b();
            }
            bVar = goA;
        }
        return bVar;
    }
}
