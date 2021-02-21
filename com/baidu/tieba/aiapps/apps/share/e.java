package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes7.dex */
public class e {
    private static volatile d gmQ;

    public static synchronized d bNM() {
        d dVar;
        synchronized (e.class) {
            if (gmQ == null) {
                gmQ = new d();
            }
            dVar = gmQ;
        }
        return dVar;
    }
}
