package com.baidu.tieba.aiapps.apps.media.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eev;

    public static synchronized a aZZ() {
        a aVar;
        synchronized (b.class) {
            if (eev == null) {
                eev = new a();
            }
            aVar = eev;
        }
        return aVar;
    }
}
