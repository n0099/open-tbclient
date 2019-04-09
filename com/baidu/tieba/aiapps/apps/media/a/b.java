package com.baidu.tieba.aiapps.apps.media.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cVb;

    public static synchronized a azt() {
        a aVar;
        synchronized (b.class) {
            if (cVb == null) {
                cVb = new a();
            }
            aVar = cVb;
        }
        return aVar;
    }
}
