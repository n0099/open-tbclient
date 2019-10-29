package com.baidu.tieba.aiapps.apps.media.b;
/* loaded from: classes2.dex */
public class d {
    private static volatile c dqy;

    public static synchronized c aGY() {
        c cVar;
        synchronized (d.class) {
            if (dqy == null) {
                dqy = new c();
            }
            cVar = dqy;
        }
        return cVar;
    }
}
