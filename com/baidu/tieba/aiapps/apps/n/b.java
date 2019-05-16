package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dfO;

    public static synchronized a aFW() {
        a aVar;
        synchronized (b.class) {
            if (dfO == null) {
                dfO = new a();
            }
            aVar = dfO;
        }
        return aVar;
    }
}
