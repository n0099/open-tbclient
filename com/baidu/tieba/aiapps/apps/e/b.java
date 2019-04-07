package com.baidu.tieba.aiapps.apps.e;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cTa;

    public static synchronized a ayY() {
        a aVar;
        synchronized (b.class) {
            if (cTa == null) {
                cTa = new a();
            }
            aVar = cTa;
        }
        return aVar;
    }
}
