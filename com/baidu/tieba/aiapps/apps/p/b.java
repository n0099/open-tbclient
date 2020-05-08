package com.baidu.tieba.aiapps.apps.p;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eGI;

    public static synchronized a bju() {
        a aVar;
        synchronized (b.class) {
            if (eGI == null) {
                eGI = new a();
            }
            aVar = eGI;
        }
        return aVar;
    }
}
