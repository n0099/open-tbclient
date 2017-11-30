package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aMa;
    private static ContentProvider aMb;
    private static BroadcastReceiver aMc;
    private static BroadcastReceiver aMd;

    public static Service GP() {
        return aMa;
    }

    public static void a(Service service) {
        aMa = service;
    }

    public static ContentProvider GQ() {
        return aMb;
    }

    public static void a(ContentProvider contentProvider) {
        aMb = contentProvider;
    }

    public static BroadcastReceiver GR() {
        return aMc;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aMc = broadcastReceiver;
    }

    public static BroadcastReceiver GS() {
        return aMd;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        aMd = broadcastReceiver;
    }
}
