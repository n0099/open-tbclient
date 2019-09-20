package com.baidu.tieba.aiapps.apps.address;
/* loaded from: classes2.dex */
public class b {
    private static volatile a ddD;

    public static synchronized a aFq() {
        a aVar;
        synchronized (b.class) {
            if (ddD == null) {
                ddD = new a();
            }
            aVar = ddD;
        }
        return aVar;
    }
}
