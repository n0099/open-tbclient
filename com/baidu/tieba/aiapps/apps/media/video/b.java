package com.baidu.tieba.aiapps.apps.media.video;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cVy;

    public static synchronized a azE() {
        a aVar;
        synchronized (b.class) {
            if (cVy == null) {
                cVy = new a();
            }
            aVar = cVy;
        }
        return aVar;
    }
}
