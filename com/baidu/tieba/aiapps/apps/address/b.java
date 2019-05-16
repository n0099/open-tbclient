package com.baidu.tieba.aiapps.apps.address;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dah;

    public static synchronized a aDr() {
        a aVar;
        synchronized (b.class) {
            if (dah == null) {
                dah = new a();
            }
            aVar = dah;
        }
        return aVar;
    }
}
