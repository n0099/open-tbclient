package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service bCp;
    private static ContentProvider bCq;
    private static BroadcastReceiver bCr;
    private static BroadcastReceiver bCs;

    public static Service OK() {
        return bCp;
    }

    public static void a(Service service) {
        bCp = service;
    }

    public static ContentProvider OL() {
        return bCq;
    }

    public static void a(ContentProvider contentProvider) {
        bCq = contentProvider;
    }

    public static BroadcastReceiver OM() {
        return bCr;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        bCr = broadcastReceiver;
    }

    public static BroadcastReceiver ON() {
        return bCs;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        bCs = broadcastReceiver;
    }
}
