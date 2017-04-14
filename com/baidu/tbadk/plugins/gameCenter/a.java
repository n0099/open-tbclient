package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aIm;
    private static ContentProvider aIn;
    private static BroadcastReceiver aIo;
    private static BroadcastReceiver aIp;

    public static Service GV() {
        return aIm;
    }

    public static void a(Service service) {
        aIm = service;
    }

    public static ContentProvider GW() {
        return aIn;
    }

    public static void a(ContentProvider contentProvider) {
        aIn = contentProvider;
    }

    public static BroadcastReceiver GX() {
        return aIo;
    }

    public static void a(BroadcastReceiver broadcastReceiver) {
        aIo = broadcastReceiver;
    }

    public static BroadcastReceiver GY() {
        return aIp;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aIp = broadcastReceiver;
    }
}
