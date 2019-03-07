package com.baidu.tieba.aiapps.apps.media.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cVc;

    public static synchronized a azw() {
        a aVar;
        synchronized (b.class) {
            if (cVc == null) {
                cVc = new a();
            }
            aVar = cVc;
        }
        return aVar;
    }
}
