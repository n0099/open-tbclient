package com.baidu.tieba.aiapps.apps.q;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cWS;

    public static synchronized a aAg() {
        a aVar;
        synchronized (b.class) {
            if (cWS == null) {
                cWS = new a();
            }
            aVar = cWS;
        }
        return aVar;
    }
}
