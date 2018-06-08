package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aUF;
    private static BroadcastReceiver aUG;
    private static BroadcastReceiver aUH;
    private static ContentProvider aUx;

    public static Service KG() {
        return aUF;
    }

    public static void a(Service service) {
        aUF = service;
    }

    public static ContentProvider KE() {
        return aUx;
    }

    public static void a(ContentProvider contentProvider) {
        aUx = contentProvider;
    }

    public static BroadcastReceiver KH() {
        return aUG;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aUG = broadcastReceiver;
    }

    public static BroadcastReceiver KI() {
        return aUH;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        aUH = broadcastReceiver;
    }
}
