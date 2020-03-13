package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eea;

    public static synchronized a aZU() {
        a aVar;
        synchronized (b.class) {
            if (eea == null) {
                eea = new a();
            }
            aVar = eea;
        }
        return aVar;
    }
}
