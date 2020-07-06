package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes7.dex */
public class b {
    private static volatile a fcQ;

    public static synchronized a bqF() {
        a aVar;
        synchronized (b.class) {
            if (fcQ == null) {
                fcQ = new a();
            }
            aVar = fcQ;
        }
        return aVar;
    }
}
