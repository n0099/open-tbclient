package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes6.dex */
public class c {
    private static volatile b gjW;

    public static synchronized b bNg() {
        b bVar;
        synchronized (c.class) {
            if (gjW == null) {
                gjW = new b();
            }
            bVar = gjW;
        }
        return bVar;
    }
}
