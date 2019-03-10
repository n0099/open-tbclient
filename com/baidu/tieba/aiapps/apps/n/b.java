package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cWx;

    public static synchronized a azS() {
        a aVar;
        synchronized (b.class) {
            if (cWx == null) {
                cWx = new a();
            }
            aVar = cWx;
        }
        return aVar;
    }
}
