package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes7.dex */
public class b {
    private static volatile a glO;

    public static synchronized a bMY() {
        a aVar;
        synchronized (b.class) {
            if (glO == null) {
                glO = new a();
            }
            aVar = glO;
        }
        return aVar;
    }
}
