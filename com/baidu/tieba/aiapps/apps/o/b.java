package com.baidu.tieba.aiapps.apps.o;
/* loaded from: classes7.dex */
public class b {
    private static volatile a egw;

    public static synchronized a bbo() {
        a aVar;
        synchronized (b.class) {
            if (egw == null) {
                egw = new a();
            }
            aVar = egw;
        }
        return aVar;
    }
}
