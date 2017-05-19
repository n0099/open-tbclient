package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aIs;
    private static ContentProvider aIt;
    private static BroadcastReceiver aIu;
    private static BroadcastReceiver aIv;

    public static Service FZ() {
        return aIs;
    }

    public static void a(Service service) {
        aIs = service;
    }

    public static ContentProvider Ga() {
        return aIt;
    }

    public static void a(ContentProvider contentProvider) {
        aIt = contentProvider;
    }

    public static BroadcastReceiver Gb() {
        return aIu;
    }

    public static void a(BroadcastReceiver broadcastReceiver) {
        aIu = broadcastReceiver;
    }

    public static BroadcastReceiver Gc() {
        return aIv;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aIv = broadcastReceiver;
    }
}
