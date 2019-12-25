package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes4.dex */
public class c {
    private static volatile b ebV;

    public static synchronized b aYA() {
        b bVar;
        synchronized (c.class) {
            if (ebV == null) {
                ebV = new b();
            }
            bVar = ebV;
        }
        return bVar;
    }
}
