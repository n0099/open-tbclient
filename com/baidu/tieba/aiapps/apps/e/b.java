package com.baidu.tieba.aiapps.apps.e;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eDX;

    public static synchronized a bhZ() {
        a aVar;
        synchronized (b.class) {
            if (eDX == null) {
                eDX = new a();
            }
            aVar = eDX;
        }
        return aVar;
    }
}
