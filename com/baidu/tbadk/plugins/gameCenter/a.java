package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aLR;
    private static ContentProvider aLS;
    private static BroadcastReceiver aLT;
    private static BroadcastReceiver aLU;

    public static Service GO() {
        return aLR;
    }

    public static void a(Service service) {
        aLR = service;
    }

    public static ContentProvider GP() {
        return aLS;
    }

    public static void a(ContentProvider contentProvider) {
        aLS = contentProvider;
    }

    public static BroadcastReceiver GQ() {
        return aLT;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aLT = broadcastReceiver;
    }

    public static BroadcastReceiver GR() {
        return aLU;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        aLU = broadcastReceiver;
    }
}
