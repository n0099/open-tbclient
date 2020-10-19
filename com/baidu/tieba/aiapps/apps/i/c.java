package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes20.dex */
public class c {
    private static volatile b fJj;

    public static synchronized b bHl() {
        b bVar;
        synchronized (c.class) {
            if (fJj == null) {
                fJj = new b();
            }
            bVar = fJj;
        }
        return bVar;
    }
}
