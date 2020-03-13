package com.baidu.tieba.aiapps.apps.e;
/* loaded from: classes7.dex */
public class b {
    private static volatile a edQ;

    public static synchronized a aZR() {
        a aVar;
        synchronized (b.class) {
            if (edQ == null) {
                edQ = new a();
            }
            aVar = edQ;
        }
        return aVar;
    }
}
