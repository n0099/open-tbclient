package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes14.dex */
public class d {
    private static volatile c ftW;

    public static synchronized c bDs() {
        c cVar;
        synchronized (d.class) {
            if (ftW == null) {
                ftW = new c();
            }
            cVar = ftW;
        }
        return cVar;
    }
}
