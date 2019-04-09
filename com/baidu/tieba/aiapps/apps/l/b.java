package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cWo;

    public static synchronized a azL() {
        a aVar;
        synchronized (b.class) {
            if (cWo == null) {
                cWo = new a();
            }
            aVar = cWo;
        }
        return aVar;
    }
}
