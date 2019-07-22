package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes2.dex */
public class d {
    private static volatile c dht;

    public static synchronized c aHw() {
        c cVar;
        synchronized (d.class) {
            if (dht == null) {
                dht = new c();
            }
            cVar = dht;
        }
        return cVar;
    }
}
