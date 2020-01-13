package com.baidu.tieba.aiapps.apps.o;
/* loaded from: classes5.dex */
public class b {
    private static volatile a ecf;

    public static synchronized a aYW() {
        a aVar;
        synchronized (b.class) {
            if (ecf == null) {
                ecf = new a();
            }
            aVar = ecf;
        }
        return aVar;
    }
}
