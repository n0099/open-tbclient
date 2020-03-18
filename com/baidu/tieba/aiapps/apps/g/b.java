package com.baidu.tieba.aiapps.apps.g;
/* loaded from: classes7.dex */
public class b {
    private static volatile a egl;

    public static synchronized a baM() {
        a aVar;
        synchronized (b.class) {
            if (egl == null) {
                egl = new a();
            }
            aVar = egl;
        }
        return aVar;
    }
}
