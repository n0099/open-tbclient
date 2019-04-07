package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cUV;

    public static synchronized a azs() {
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
