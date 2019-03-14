package com.baidu.tieba.aiapps.apps.g;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cUR;

    public static synchronized a azu() {
        a aVar;
        synchronized (b.class) {
            if (cUR == null) {
                cUR = new a();
            }
            aVar = cUR;
        }
        return aVar;
    }
}
