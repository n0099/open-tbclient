package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fWH;

    public static synchronized a bKW() {
        a aVar;
        synchronized (b.class) {
            if (fWH == null) {
                fWH = new a();
            }
            aVar = fWH;
        }
        return aVar;
    }
}
