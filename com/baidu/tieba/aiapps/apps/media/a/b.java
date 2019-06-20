package com.baidu.tieba.aiapps.apps.media.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a ddB;

    public static synchronized a aEL() {
        a aVar;
        synchronized (b.class) {
            if (ddB == null) {
                ddB = new a();
            }
            aVar = ddB;
        }
        return aVar;
    }
}
