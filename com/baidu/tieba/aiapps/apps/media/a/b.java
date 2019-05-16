package com.baidu.tieba.aiapps.apps.media.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a ddz;

    public static synchronized a aEI() {
        a aVar;
        synchronized (b.class) {
            if (ddz == null) {
                ddz = new a();
            }
            aVar = ddz;
        }
        return aVar;
    }
}
