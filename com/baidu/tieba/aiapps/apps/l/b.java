package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cWl;

    public static synchronized a azO() {
        a aVar;
        synchronized (b.class) {
            if (cWl == null) {
                cWl = new a();
            }
            aVar = cWl;
        }
        return aVar;
    }
}
