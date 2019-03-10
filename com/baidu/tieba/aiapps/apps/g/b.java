package com.baidu.tieba.aiapps.apps.g;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cUV;

    public static synchronized a azv() {
        a aVar;
        synchronized (b.class) {
            if (cUV == null) {
                cUV = new a();
            }
            aVar = cUV;
        }
        return aVar;
    }
}
