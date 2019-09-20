package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes2.dex */
public class b {
    private static volatile a deW;

    public static synchronized a aGl() {
        a aVar;
        synchronized (b.class) {
            if (deW == null) {
                deW = new a();
            }
            aVar = deW;
        }
        return aVar;
    }
}
