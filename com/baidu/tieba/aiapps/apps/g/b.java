package com.baidu.tieba.aiapps.apps.g;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eGb;

    public static synchronized a biP() {
        a aVar;
        synchronized (b.class) {
            if (eGb == null) {
                eGb = new a();
            }
            aVar = eGb;
        }
        return aVar;
    }
}
