package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aKU;
    private static ContentProvider aKV;
    private static BroadcastReceiver aKW;
    private static BroadcastReceiver aKX;

    public static Service Gr() {
        return aKU;
    }

    public static void a(Service service) {
        aKU = service;
    }

    public static ContentProvider Gs() {
        return aKV;
    }

    public static void a(ContentProvider contentProvider) {
        aKV = contentProvider;
    }

    public static BroadcastReceiver Gt() {
        return aKW;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aKW = broadcastReceiver;
    }

    public static BroadcastReceiver Gu() {
        return aKX;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        aKX = broadcastReceiver;
    }
}
