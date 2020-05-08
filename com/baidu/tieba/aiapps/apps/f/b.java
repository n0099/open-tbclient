package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eEm;

    public static synchronized a bia() {
        a aVar;
        synchronized (b.class) {
            if (eEm == null) {
                eEm = new a();
            }
            aVar = eEm;
        }
        return aVar;
    }
}
