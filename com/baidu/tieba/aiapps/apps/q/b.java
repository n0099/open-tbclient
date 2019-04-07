package com.baidu.tieba.aiapps.apps.q;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cWQ;

    public static synchronized a aAc() {
        a aVar;
        synchronized (b.class) {
            if (cWQ == null) {
                cWQ = new a();
            }
            aVar = cWQ;
        }
        return aVar;
    }
}
