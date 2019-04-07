package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cUP;

    public static synchronized a azq() {
        a aVar;
        synchronized (b.class) {
            if (cUP == null) {
                cUP = new a();
            }
            aVar = cUP;
        }
        return aVar;
    }
}
