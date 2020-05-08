package com.baidu.tieba.aiapps.apps.o;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eGH;

    public static synchronized a bjt() {
        a aVar;
        synchronized (b.class) {
            if (eGH == null) {
                eGH = new a();
            }
            aVar = eGH;
        }
        return aVar;
    }
}
