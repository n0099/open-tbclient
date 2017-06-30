package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aJt;
    private static ContentProvider aJu;
    private static BroadcastReceiver aJv;
    private static BroadcastReceiver aJw;

    public static Service Gq() {
        return aJt;
    }

    public static void a(Service service) {
        aJt = service;
    }

    public static ContentProvider Gr() {
        return aJu;
    }

    public static void a(ContentProvider contentProvider) {
        aJu = contentProvider;
    }

    public static BroadcastReceiver Gs() {
        return aJv;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aJv = broadcastReceiver;
    }

    public static BroadcastReceiver Gt() {
        return aJw;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        aJw = broadcastReceiver;
    }
}
