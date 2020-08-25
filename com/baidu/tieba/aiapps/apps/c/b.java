package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes14.dex */
public class b {
    private static volatile a fsX;

    public static synchronized a bCF() {
        a aVar;
        synchronized (b.class) {
            if (fsX == null) {
                fsX = new a();
            }
            aVar = fsX;
        }
        return aVar;
    }
}
