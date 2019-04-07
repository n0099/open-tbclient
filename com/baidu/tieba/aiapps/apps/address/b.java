package com.baidu.tieba.aiapps.apps.address;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cRN;

    public static synchronized a ayj() {
        a aVar;
        synchronized (b.class) {
            if (cRN == null) {
                cRN = new a();
            }
            aVar = cRN;
        }
        return aVar;
    }
}
