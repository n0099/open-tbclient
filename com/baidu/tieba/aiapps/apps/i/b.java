package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eGc;

    public static synchronized a biR() {
        a aVar;
        synchronized (b.class) {
            if (eGc == null) {
                eGc = new a();
            }
            aVar = eGc;
        }
        return aVar;
    }
}
