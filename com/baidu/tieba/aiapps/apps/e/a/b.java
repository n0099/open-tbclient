package com.baidu.tieba.aiapps.apps.e.a;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fWW;

    public static synchronized a bLa() {
        a aVar;
        synchronized (b.class) {
            if (fWW == null) {
                fWW = new a();
            }
            aVar = fWW;
        }
        return aVar;
    }
}
