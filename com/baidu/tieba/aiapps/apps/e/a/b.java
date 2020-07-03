package com.baidu.tieba.aiapps.apps.e.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a fdi;

    public static synchronized a bqK() {
        a aVar;
        synchronized (b.class) {
            if (fdi == null) {
                fdi = new a();
            }
            aVar = fdi;
        }
        return aVar;
    }
}
