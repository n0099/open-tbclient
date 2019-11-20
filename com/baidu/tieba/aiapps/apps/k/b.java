package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes2.dex */
public class b {
    private static volatile a drw;

    public static synchronized a aHN() {
        a aVar;
        synchronized (b.class) {
            if (drw == null) {
                drw = new a();
            }
            aVar = drw;
        }
        return aVar;
    }
}
