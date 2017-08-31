package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aLw;
    private static ContentProvider aLx;
    private static BroadcastReceiver aLy;
    private static BroadcastReceiver aLz;

    public static Service GM() {
        return aLw;
    }

    public static void a(Service service) {
        aLw = service;
    }

    public static ContentProvider GN() {
        return aLx;
    }

    public static void a(ContentProvider contentProvider) {
        aLx = contentProvider;
    }

    public static BroadcastReceiver GO() {
        return aLy;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aLy = broadcastReceiver;
    }

    public static BroadcastReceiver GP() {
        return aLz;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        aLz = broadcastReceiver;
    }
}
