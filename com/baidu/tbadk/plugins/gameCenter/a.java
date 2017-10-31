package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aLr;
    private static ContentProvider aLs;
    private static BroadcastReceiver aLt;
    private static BroadcastReceiver aLu;

    public static Service Gx() {
        return aLr;
    }

    public static void a(Service service) {
        aLr = service;
    }

    public static ContentProvider Gy() {
        return aLs;
    }

    public static void a(ContentProvider contentProvider) {
        aLs = contentProvider;
    }

    public static BroadcastReceiver Gz() {
        return aLt;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aLt = broadcastReceiver;
    }

    public static BroadcastReceiver GA() {
        return aLu;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        aLu = broadcastReceiver;
    }
}
