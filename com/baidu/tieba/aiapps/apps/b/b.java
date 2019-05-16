package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cZP;

    public static synchronized a aDh() {
        a aVar;
        synchronized (b.class) {
            if (cZP == null) {
                cZP = new a();
            }
            aVar = cZP;
        }
        return aVar;
    }
}
