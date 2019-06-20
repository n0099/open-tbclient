package com.baidu.tieba.aiapps.apps.media.b;
/* loaded from: classes2.dex */
public class e {
    private static volatile d ddK;

    public static synchronized d aEN() {
        d dVar;
        synchronized (e.class) {
            if (ddK == null) {
                ddK = new d();
            }
            dVar = ddK;
        }
        return dVar;
    }
}
