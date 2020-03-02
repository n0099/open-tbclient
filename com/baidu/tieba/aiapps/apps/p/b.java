package com.baidu.tieba.aiapps.apps.p;
/* loaded from: classes7.dex */
public class b {
    private static volatile a egk;

    public static synchronized a bbo() {
        a aVar;
        synchronized (b.class) {
            if (egk == null) {
                egk = new a();
            }
            aVar = egk;
        }
        return aVar;
    }
}
