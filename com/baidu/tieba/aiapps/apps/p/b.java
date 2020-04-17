package com.baidu.tieba.aiapps.apps.p;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eGD;

    public static synchronized a bjw() {
        a aVar;
        synchronized (b.class) {
            if (eGD == null) {
                eGD = new a();
            }
            aVar = eGD;
        }
        return aVar;
    }
}
