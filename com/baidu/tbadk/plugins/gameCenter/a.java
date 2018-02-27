package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service bCc;
    private static ContentProvider bCd;
    private static BroadcastReceiver bCe;
    private static BroadcastReceiver bCf;

    public static Service OJ() {
        return bCc;
    }

    public static void a(Service service) {
        bCc = service;
    }

    public static ContentProvider OK() {
        return bCd;
    }

    public static void a(ContentProvider contentProvider) {
        bCd = contentProvider;
    }

    public static BroadcastReceiver OL() {
        return bCe;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        bCe = broadcastReceiver;
    }

    public static BroadcastReceiver OM() {
        return bCf;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        bCf = broadcastReceiver;
    }
}
