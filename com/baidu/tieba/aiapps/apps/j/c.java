package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes5.dex */
public class c {
    private static volatile b ebK;

    public static synchronized b aYL() {
        b bVar;
        synchronized (c.class) {
            if (ebK == null) {
                ebK = new b();
            }
            bVar = ebK;
        }
        return bVar;
    }
}
