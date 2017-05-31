package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aIf;
    private static ContentProvider aIg;
    private static BroadcastReceiver aIh;
    private static BroadcastReceiver aIi;

    public static Service FT() {
        return aIf;
    }

    public static void a(Service service) {
        aIf = service;
    }

    public static ContentProvider FU() {
        return aIg;
    }

    public static void a(ContentProvider contentProvider) {
        aIg = contentProvider;
    }

    public static BroadcastReceiver FV() {
        return aIh;
    }

    public static void a(BroadcastReceiver broadcastReceiver) {
        aIh = broadcastReceiver;
    }

    public static BroadcastReceiver FW() {
        return aIi;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aIi = broadcastReceiver;
    }
}
