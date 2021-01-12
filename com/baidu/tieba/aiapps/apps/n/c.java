package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes6.dex */
public class c {
    private static volatile b gll;

    public static synchronized b bNp() {
        b bVar;
        synchronized (c.class) {
            if (gll == null) {
                gll = new b();
            }
            bVar = gll;
        }
        return bVar;
    }
}
