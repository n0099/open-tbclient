package com.baidu.tieba.aiapps.apps.e;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dny;

    public static synchronized a aGv() {
        a aVar;
        synchronized (b.class) {
            if (dny == null) {
                dny = new a();
            }
            aVar = dny;
        }
        return aVar;
    }
}
