package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aMe;
    private static ContentProvider aMf;
    private static BroadcastReceiver aMg;
    private static BroadcastReceiver aMh;

    public static Service GQ() {
        return aMe;
    }

    public static void a(Service service) {
        aMe = service;
    }

    public static ContentProvider GR() {
        return aMf;
    }

    public static void a(ContentProvider contentProvider) {
        aMf = contentProvider;
    }

    public static BroadcastReceiver GS() {
        return aMg;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aMg = broadcastReceiver;
    }

    public static BroadcastReceiver GT() {
        return aMh;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        aMh = broadcastReceiver;
    }
}
