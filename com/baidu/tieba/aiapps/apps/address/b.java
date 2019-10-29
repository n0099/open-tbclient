package com.baidu.tieba.aiapps.apps.address;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dmX;

    public static synchronized a aFC() {
        a aVar;
        synchronized (b.class) {
            if (dmX == null) {
                dmX = new a();
            }
            aVar = dmX;
        }
        return aVar;
    }
}
