package com.baidu.tieba.aiapps.apps.media.a;
/* loaded from: classes5.dex */
public class b {
    private static volatile a dZO;

    public static synchronized a aXD() {
        a aVar;
        synchronized (b.class) {
            if (dZO == null) {
                dZO = new a();
            }
            aVar = dZO;
        }
        return aVar;
    }
}
