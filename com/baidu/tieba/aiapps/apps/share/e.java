package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes6.dex */
public class e {
    private static volatile d gjV;

    public static synchronized d bNe() {
        d dVar;
        synchronized (e.class) {
            if (gjV == null) {
                gjV = new d();
            }
            dVar = gjV;
        }
        return dVar;
    }
}
