package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes6.dex */
public class b {
    private static volatile a gjh;

    public static synchronized a bMx() {
        a aVar;
        synchronized (b.class) {
            if (gjh == null) {
                gjh = new a();
            }
            aVar = gjh;
        }
        return aVar;
    }
}
