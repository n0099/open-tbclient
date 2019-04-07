package com.baidu.tieba.aiapps.apps.media.video;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cVA;

    public static synchronized a azB() {
        a aVar;
        synchronized (b.class) {
            if (cVA == null) {
                cVA = new a();
            }
            aVar = cVA;
        }
        return aVar;
    }
}
