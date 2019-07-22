package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes2.dex */
public class b {
    private static volatile a ddc;

    public static synchronized a aFF() {
        a aVar;
        synchronized (b.class) {
            if (ddc == null) {
                ddc = new a();
            }
            aVar = ddc;
        }
        return aVar;
    }
}
