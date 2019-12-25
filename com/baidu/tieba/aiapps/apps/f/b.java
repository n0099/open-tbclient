package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes4.dex */
public class b {
    private static volatile a dZz;

    public static synchronized a aXi() {
        a aVar;
        synchronized (b.class) {
            if (dZz == null) {
                dZz = new a();
            }
            aVar = dZz;
        }
        return aVar;
    }
}
