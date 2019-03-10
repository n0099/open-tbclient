package com.baidu.tieba.aiapps.apps.e;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cTc;

    public static synchronized a azc() {
        a aVar;
        synchronized (b.class) {
            if (cTc == null) {
                cTc = new a();
            }
            aVar = cTc;
        }
        return aVar;
    }
}
