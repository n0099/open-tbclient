package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aLQ;
    private static ContentProvider aLR;
    private static BroadcastReceiver aLS;
    private static BroadcastReceiver aLT;

    public static Service GO() {
        return aLQ;
    }

    public static void a(Service service) {
        aLQ = service;
    }

    public static ContentProvider GP() {
        return aLR;
    }

    public static void a(ContentProvider contentProvider) {
        aLR = contentProvider;
    }

    public static BroadcastReceiver GQ() {
        return aLS;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aLS = broadcastReceiver;
    }

    public static BroadcastReceiver GR() {
        return aLT;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        aLT = broadcastReceiver;
    }
}
