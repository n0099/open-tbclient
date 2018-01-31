package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service bAl;
    private static ContentProvider bAm;
    private static BroadcastReceiver bAn;
    private static BroadcastReceiver bAo;

    public static Service Of() {
        return bAl;
    }

    public static void a(Service service) {
        bAl = service;
    }

    public static ContentProvider Og() {
        return bAm;
    }

    public static void a(ContentProvider contentProvider) {
        bAm = contentProvider;
    }

    public static BroadcastReceiver Oh() {
        return bAn;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        bAn = broadcastReceiver;
    }

    public static BroadcastReceiver Oi() {
        return bAo;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        bAo = broadcastReceiver;
    }
}
