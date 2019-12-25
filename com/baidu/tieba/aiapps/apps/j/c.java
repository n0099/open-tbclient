package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes4.dex */
public class c {
    private static volatile b ebB;

    public static synchronized b aYr() {
        b bVar;
        synchronized (c.class) {
            if (ebB == null) {
                ebB = new b();
            }
            bVar = ebB;
        }
        return bVar;
    }
}
