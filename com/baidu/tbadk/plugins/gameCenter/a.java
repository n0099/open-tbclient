package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aLS;
    private static ContentProvider aLT;
    private static BroadcastReceiver aLU;
    private static BroadcastReceiver aLV;

    public static Service GO() {
        return aLS;
    }

    public static void a(Service service) {
        aLS = service;
    }

    public static ContentProvider GP() {
        return aLT;
    }

    public static void a(ContentProvider contentProvider) {
        aLT = contentProvider;
    }

    public static BroadcastReceiver GQ() {
        return aLU;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aLU = broadcastReceiver;
    }

    public static BroadcastReceiver GR() {
        return aLV;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        aLV = broadcastReceiver;
    }
}
