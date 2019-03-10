package com.baidu.tieba.aiapps.apps.address;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cRP;

    public static synchronized a ayn() {
        a aVar;
        synchronized (b.class) {
            if (cRP == null) {
                cRP = new a();
            }
            aVar = cRP;
        }
        return aVar;
    }
}
