package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eDU;

    public static synchronized a bhX() {
        a aVar;
        synchronized (b.class) {
            if (eDU == null) {
                eDU = new a();
            }
            aVar = eDU;
        }
        return aVar;
    }
}
