package com.baidu.tieba.aiapps.apps.media.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a ddA;

    public static synchronized a aEL() {
        a aVar;
        synchronized (b.class) {
            if (ddA == null) {
                ddA = new a();
            }
            aVar = ddA;
        }
        return aVar;
    }
}
