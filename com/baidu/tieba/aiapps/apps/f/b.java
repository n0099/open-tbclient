package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dnz;

    public static synchronized a aGw() {
        a aVar;
        synchronized (b.class) {
            if (dnz == null) {
                dnz = new a();
            }
            aVar = dnz;
        }
        return aVar;
    }
}
