package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider aLA;
    private static BroadcastReceiver aLB;
    private static BroadcastReceiver aLC;
    private static Service aLz;

    public static Service GI() {
        return aLz;
    }

    public static void a(Service service) {
        aLz = service;
    }

    public static ContentProvider GJ() {
        return aLA;
    }

    public static void a(ContentProvider contentProvider) {
        aLA = contentProvider;
    }

    public static BroadcastReceiver GK() {
        return aLB;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aLB = broadcastReceiver;
    }

    public static BroadcastReceiver GL() {
        return aLC;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        aLC = broadcastReceiver;
    }
}
