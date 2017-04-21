package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aIo;
    private static ContentProvider aIp;
    private static BroadcastReceiver aIq;
    private static BroadcastReceiver aIr;

    public static Service GV() {
        return aIo;
    }

    public static void a(Service service) {
        aIo = service;
    }

    public static ContentProvider GW() {
        return aIp;
    }

    public static void a(ContentProvider contentProvider) {
        aIp = contentProvider;
    }

    public static BroadcastReceiver GX() {
        return aIq;
    }

    public static void a(BroadcastReceiver broadcastReceiver) {
        aIq = broadcastReceiver;
    }

    public static BroadcastReceiver GY() {
        return aIr;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aIr = broadcastReceiver;
    }
}
