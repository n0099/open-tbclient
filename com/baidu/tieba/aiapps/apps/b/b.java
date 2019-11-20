package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dlO;

    public static synchronized a aFq() {
        a aVar;
        synchronized (b.class) {
            if (dlO == null) {
                dlO = new a();
            }
            aVar = dlO;
        }
        return aVar;
    }
}
