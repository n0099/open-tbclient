package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service bCf;
    private static ContentProvider bCg;
    private static BroadcastReceiver bCh;
    private static BroadcastReceiver bCi;

    public static Service OK() {
        return bCf;
    }

    public static void a(Service service) {
        bCf = service;
    }

    public static ContentProvider OL() {
        return bCg;
    }

    public static void a(ContentProvider contentProvider) {
        bCg = contentProvider;
    }

    public static BroadcastReceiver OM() {
        return bCh;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        bCh = broadcastReceiver;
    }

    public static BroadcastReceiver ON() {
        return bCi;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        bCi = broadcastReceiver;
    }
}
