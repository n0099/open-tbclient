package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes2.dex */
public class b {
    private static volatile a ddp;

    public static synchronized a aEI() {
        a aVar;
        synchronized (b.class) {
            if (ddp == null) {
                ddp = new a();
            }
            aVar = ddp;
        }
        return aVar;
    }
}
