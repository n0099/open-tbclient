package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes19.dex */
public class c {
    private static volatile b fXb;

    public static synchronized b bKW() {
        b bVar;
        synchronized (c.class) {
            if (fXb == null) {
                fXb = new b();
            }
            bVar = fXb;
        }
        return bVar;
    }
}
