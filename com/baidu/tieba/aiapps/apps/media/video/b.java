package com.baidu.tieba.aiapps.apps.media.video;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cVC;

    public static synchronized a azE() {
        a aVar;
        synchronized (b.class) {
            if (cVC == null) {
                cVC = new a();
            }
            aVar = cVC;
        }
        return aVar;
    }
}
