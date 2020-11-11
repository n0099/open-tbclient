package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fXv;

    public static synchronized a bLE() {
        a aVar;
        synchronized (b.class) {
            if (fXv == null) {
                fXv = new a();
            }
            aVar = fXv;
        }
        return aVar;
    }
}
