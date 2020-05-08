package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eGh;

    public static synchronized a biP() {
        a aVar;
        synchronized (b.class) {
            if (eGh == null) {
                eGh = new a();
            }
            aVar = eGh;
        }
        return aVar;
    }
}
