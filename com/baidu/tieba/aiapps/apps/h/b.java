package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cUT;

    public static synchronized a azv() {
        a aVar;
        synchronized (b.class) {
            if (cUT == null) {
                cUT = new a();
            }
            aVar = cUT;
        }
        return aVar;
    }
}
