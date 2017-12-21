package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aMh;
    private static ContentProvider aMi;
    private static BroadcastReceiver aMj;
    private static BroadcastReceiver aMk;

    public static Service GQ() {
        return aMh;
    }

    public static void a(Service service) {
        aMh = service;
    }

    public static ContentProvider GR() {
        return aMi;
    }

    public static void a(ContentProvider contentProvider) {
        aMi = contentProvider;
    }

    public static BroadcastReceiver GS() {
        return aMj;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aMj = broadcastReceiver;
    }

    public static BroadcastReceiver GT() {
        return aMk;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        aMk = broadcastReceiver;
    }
}
