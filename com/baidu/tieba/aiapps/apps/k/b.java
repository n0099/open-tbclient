package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eGk;

    public static synchronized a bjl() {
        a aVar;
        synchronized (b.class) {
            if (eGk == null) {
                eGk = new a();
            }
            aVar = eGk;
        }
        return aVar;
    }
}
