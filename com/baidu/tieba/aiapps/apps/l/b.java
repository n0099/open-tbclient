package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cWn;

    public static synchronized a azL() {
        a aVar;
        synchronized (b.class) {
            if (cWn == null) {
                cWn = new a();
            }
            aVar = cWn;
        }
        return aVar;
    }
}
