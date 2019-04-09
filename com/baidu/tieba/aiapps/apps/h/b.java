package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cUW;

    public static synchronized a azs() {
        a aVar;
        synchronized (b.class) {
            if (cUW == null) {
                cUW = new a();
            }
            aVar = cUW;
        }
        return aVar;
    }
}
