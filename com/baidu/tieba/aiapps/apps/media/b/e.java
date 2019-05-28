package com.baidu.tieba.aiapps.apps.media.b;
/* loaded from: classes2.dex */
public class e {
    private static volatile d ddJ;

    public static synchronized d aEN() {
        d dVar;
        synchronized (e.class) {
            if (ddJ == null) {
                ddJ = new d();
            }
            dVar = ddJ;
        }
        return dVar;
    }
}
