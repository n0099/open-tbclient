package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes2.dex */
public class b {
    private static volatile a ddj;

    public static synchronized a aFH() {
        a aVar;
        synchronized (b.class) {
            if (ddj == null) {
                ddj = new a();
            }
            aVar = ddj;
        }
        return aVar;
    }
}
