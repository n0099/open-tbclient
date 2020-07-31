package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes14.dex */
public class d {
    private static volatile c fie;

    public static synchronized c bui() {
        c cVar;
        synchronized (d.class) {
            if (fie == null) {
                fie = new c();
            }
            cVar = fie;
        }
        return cVar;
    }
}
