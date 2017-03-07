package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aHX;
    private static ContentProvider aHY;
    private static BroadcastReceiver aHZ;
    private static BroadcastReceiver aIa;

    public static Service Gx() {
        return aHX;
    }

    public static void a(Service service) {
        aHX = service;
    }

    public static ContentProvider Gy() {
        return aHY;
    }

    public static void a(ContentProvider contentProvider) {
        aHY = contentProvider;
    }

    public static BroadcastReceiver Gz() {
        return aHZ;
    }

    public static void a(BroadcastReceiver broadcastReceiver) {
        aHZ = broadcastReceiver;
    }

    public static BroadcastReceiver GA() {
        return aIa;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aIa = broadcastReceiver;
    }
}
