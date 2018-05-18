package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aMH;
    private static BroadcastReceiver aMI;
    private static BroadcastReceiver aMJ;
    private static ContentProvider aMz;

    public static Service Hm() {
        return aMH;
    }

    public static void a(Service service) {
        aMH = service;
    }

    public static ContentProvider Hk() {
        return aMz;
    }

    public static void a(ContentProvider contentProvider) {
        aMz = contentProvider;
    }

    public static BroadcastReceiver Hn() {
        return aMI;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aMI = broadcastReceiver;
    }

    public static BroadcastReceiver Ho() {
        return aMJ;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        aMJ = broadcastReceiver;
    }
}
