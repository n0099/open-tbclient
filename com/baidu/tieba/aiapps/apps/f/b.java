package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cUN;

    public static synchronized a azt() {
        a aVar;
        synchronized (b.class) {
            if (cUN == null) {
                cUN = new a();
            }
            aVar = cUN;
        }
        return aVar;
    }
}
