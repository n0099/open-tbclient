package com.baidu.tieba.aiapps.apps.g;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cUT;

    public static synchronized a azr() {
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
