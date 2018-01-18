package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service bAd;
    private static ContentProvider bAe;
    private static BroadcastReceiver bAf;
    private static BroadcastReceiver bAg;

    public static Service Od() {
        return bAd;
    }

    public static void a(Service service) {
        bAd = service;
    }

    public static ContentProvider Oe() {
        return bAe;
    }

    public static void a(ContentProvider contentProvider) {
        bAe = contentProvider;
    }

    public static BroadcastReceiver Of() {
        return bAf;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        bAf = broadcastReceiver;
    }

    public static BroadcastReceiver Og() {
        return bAg;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        bAg = broadcastReceiver;
    }
}
