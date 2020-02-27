package com.baidu.tieba.aiapps.apps.p;
/* loaded from: classes7.dex */
public class b {
    private static volatile a egj;

    public static synchronized a bbm() {
        a aVar;
        synchronized (b.class) {
            if (egj == null) {
                egj = new a();
            }
            aVar = egj;
        }
        return aVar;
    }
}
