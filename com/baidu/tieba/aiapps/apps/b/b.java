package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cZQ;

    public static synchronized a aDk() {
        a aVar;
        synchronized (b.class) {
            if (cZQ == null) {
                cZQ = new a();
            }
            aVar = cZQ;
        }
        return aVar;
    }
}
