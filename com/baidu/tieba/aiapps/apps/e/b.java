package com.baidu.tieba.aiapps.apps.e;
/* loaded from: classes2.dex */
public class b {
    private static volatile a doq;

    public static synchronized a aGx() {
        a aVar;
        synchronized (b.class) {
            if (doq == null) {
                doq = new a();
            }
            aVar = doq;
        }
        return aVar;
    }
}
