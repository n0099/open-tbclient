package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aKH;
    private static ContentProvider aKI;
    private static BroadcastReceiver aKJ;
    private static BroadcastReceiver aKK;

    public static Service Gl() {
        return aKH;
    }

    public static void a(Service service) {
        aKH = service;
    }

    public static ContentProvider Gm() {
        return aKI;
    }

    public static void a(ContentProvider contentProvider) {
        aKI = contentProvider;
    }

    public static BroadcastReceiver Gn() {
        return aKJ;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aKJ = broadcastReceiver;
    }

    public static BroadcastReceiver Go() {
        return aKK;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        aKK = broadcastReceiver;
    }
}
