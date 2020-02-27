package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes7.dex */
public class b {
    private static volatile a edM;

    public static synchronized a aZR() {
        a aVar;
        synchronized (b.class) {
            if (edM == null) {
                edM = new a();
            }
            aVar = edM;
        }
        return aVar;
    }
}
