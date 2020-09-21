package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes19.dex */
public class c {
    private static volatile b fxa;

    public static synchronized b bEz() {
        b bVar;
        synchronized (c.class) {
            if (fxa == null) {
                fxa = new b();
            }
            bVar = fxa;
        }
        return bVar;
    }
}
