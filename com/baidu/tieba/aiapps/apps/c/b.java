package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eec;

    public static synchronized a aZS() {
        a aVar;
        synchronized (b.class) {
            if (eec == null) {
                eec = new a();
            }
            aVar = eec;
        }
        return aVar;
    }
}
