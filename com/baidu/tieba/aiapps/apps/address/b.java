package com.baidu.tieba.aiapps.apps.address;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cRO;

    public static synchronized a ayj() {
        a aVar;
        synchronized (b.class) {
            if (cRO == null) {
                cRO = new a();
            }
            aVar = cRO;
        }
        return aVar;
    }
}
