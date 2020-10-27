package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes20.dex */
public class c {
    private static volatile b fQN;

    public static synchronized b bIu() {
        b bVar;
        synchronized (c.class) {
            if (fQN == null) {
                fQN = new b();
            }
            bVar = fQN;
        }
        return bVar;
    }
}
