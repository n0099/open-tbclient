package com.baidu.tieba.aiapps.apps.media.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a edS;

    public static synchronized a aZU() {
        a aVar;
        synchronized (b.class) {
            if (edS == null) {
                edS = new a();
            }
            aVar = edS;
        }
        return aVar;
    }
}
