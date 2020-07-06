package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes7.dex */
public class b {
    private static volatile a fcT;

    public static synchronized a bqH() {
        a aVar;
        synchronized (b.class) {
            if (fcT == null) {
                fcT = new a();
            }
            aVar = fcT;
        }
        return aVar;
    }
}
