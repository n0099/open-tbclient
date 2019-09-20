package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes2.dex */
public class b {
    private static volatile a ddk;

    public static synchronized a aFg() {
        a aVar;
        synchronized (b.class) {
            if (ddk == null) {
                ddk = new a();
            }
            aVar = ddk;
        }
        return aVar;
    }
}
