package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes7.dex */
public class e {
    private static volatile d fdF;

    public static synchronized d bri() {
        d dVar;
        synchronized (e.class) {
            if (fdF == null) {
                fdF = new d();
            }
            dVar = fdF;
        }
        return dVar;
    }
}
