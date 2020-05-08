package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eGp;

    public static synchronized a bjj() {
        a aVar;
        synchronized (b.class) {
            if (eGp == null) {
                eGp = new a();
            }
            aVar = eGp;
        }
        return aVar;
    }
}
