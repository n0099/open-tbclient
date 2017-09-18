package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aLt;
    private static ContentProvider aLu;
    private static BroadcastReceiver aLv;
    private static BroadcastReceiver aLw;

    public static Service GM() {
        return aLt;
    }

    public static void a(Service service) {
        aLt = service;
    }

    public static ContentProvider GN() {
        return aLu;
    }

    public static void a(ContentProvider contentProvider) {
        aLu = contentProvider;
    }

    public static BroadcastReceiver GO() {
        return aLv;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aLv = broadcastReceiver;
    }

    public static BroadcastReceiver GP() {
        return aLw;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        aLw = broadcastReceiver;
    }
}
