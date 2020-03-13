package com.baidu.tieba.aiapps.apps.p;
/* loaded from: classes7.dex */
public class b {
    private static volatile a egx;

    public static synchronized a bbp() {
        a aVar;
        synchronized (b.class) {
            if (egx == null) {
                egx = new a();
            }
            aVar = egx;
        }
        return aVar;
    }
}
