package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eeq;

    public static synchronized a aZY() {
        a aVar;
        synchronized (b.class) {
            if (eeq == null) {
                eeq = new a();
            }
            aVar = eeq;
        }
        return aVar;
    }
}
