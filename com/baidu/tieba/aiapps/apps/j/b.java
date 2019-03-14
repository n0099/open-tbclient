package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cVU;

    public static synchronized a azK() {
        a aVar;
        synchronized (b.class) {
            if (cVU == null) {
                cVU = new a();
            }
            aVar = cVU;
        }
        return aVar;
    }
}
