package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cSS;

    public static synchronized a ayH() {
        a aVar;
        synchronized (b.class) {
            if (cSS == null) {
                cSS = new a();
            }
            aVar = cSS;
        }
        return aVar;
    }
}
