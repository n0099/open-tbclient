package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dom;

    public static synchronized b aGe() {
        b bVar;
        synchronized (c.class) {
            if (dom == null) {
                dom = new b();
            }
            bVar = dom;
        }
        return bVar;
    }
}
