package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aKB;
    private static ContentProvider aKC;
    private static BroadcastReceiver aKD;
    private static BroadcastReceiver aKE;

    public static Service GG() {
        return aKB;
    }

    public static void a(Service service) {
        aKB = service;
    }

    public static ContentProvider GH() {
        return aKC;
    }

    public static void a(ContentProvider contentProvider) {
        aKC = contentProvider;
    }

    public static BroadcastReceiver GI() {
        return aKD;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aKD = broadcastReceiver;
    }

    public static BroadcastReceiver GJ() {
        return aKE;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        aKE = broadcastReceiver;
    }
}
