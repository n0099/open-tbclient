package com.baidu.tieba.aiapps.apps.o;
/* loaded from: classes7.dex */
public class b {
    private static volatile a egj;

    public static synchronized a bbn() {
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
