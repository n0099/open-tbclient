package com.baidu.tieba.aiapps.apps.address;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dbP;

    public static synchronized a aEM() {
        a aVar;
        synchronized (b.class) {
            if (dbP == null) {
                dbP = new a();
            }
            aVar = dbP;
        }
        return aVar;
    }
}
