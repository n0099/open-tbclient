package com.baidu.tieba.aiapps.apps.o;
/* loaded from: classes7.dex */
public class b {
    private static volatile a egi;

    public static synchronized a bbl() {
        a aVar;
        synchronized (b.class) {
            if (egi == null) {
                egi = new a();
            }
            aVar = egi;
        }
        return aVar;
    }
}
