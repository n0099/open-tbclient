package com.baidu.tieba.aiapps.apps.media.video;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cVB;

    public static synchronized a azB() {
        a aVar;
        synchronized (b.class) {
            if (cVB == null) {
                cVB = new a();
            }
            aVar = cVB;
        }
        return aVar;
    }
}
