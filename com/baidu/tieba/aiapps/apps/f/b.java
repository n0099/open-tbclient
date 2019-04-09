package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cUQ;

    public static synchronized a azq() {
        a aVar;
        synchronized (b.class) {
            if (cUQ == null) {
                cUQ = new a();
            }
            aVar = cUQ;
        }
        return aVar;
    }
}
