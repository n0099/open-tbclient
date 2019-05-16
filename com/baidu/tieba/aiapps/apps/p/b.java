package com.baidu.tieba.aiapps.apps.p;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dfS;

    public static synchronized a aFY() {
        a aVar;
        synchronized (b.class) {
            if (dfS == null) {
                dfS = new a();
            }
            aVar = dfS;
        }
        return aVar;
    }
}
