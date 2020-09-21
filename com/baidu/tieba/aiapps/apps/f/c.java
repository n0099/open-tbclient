package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes19.dex */
public class c {
    private static volatile b fwH;

    public static synchronized b bEp() {
        b bVar;
        synchronized (c.class) {
            if (fwH == null) {
                fwH = new b();
            }
            bVar = fwH;
        }
        return bVar;
    }
}
