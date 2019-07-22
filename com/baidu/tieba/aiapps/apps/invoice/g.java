package com.baidu.tieba.aiapps.apps.invoice;
/* loaded from: classes2.dex */
public class g {
    private static volatile f ddo;

    public static synchronized f aFM() {
        f fVar;
        synchronized (g.class) {
            if (ddo == null) {
                ddo = new f();
            }
            fVar = ddo;
        }
        return fVar;
    }
}
