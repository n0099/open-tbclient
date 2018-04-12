package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aMG;
    private static BroadcastReceiver aMH;
    private static BroadcastReceiver aMI;
    private static ContentProvider aMy;

    public static Service Ho() {
        return aMG;
    }

    public static void a(Service service) {
        aMG = service;
    }

    public static ContentProvider Hm() {
        return aMy;
    }

    public static void a(ContentProvider contentProvider) {
        aMy = contentProvider;
    }

    public static BroadcastReceiver Hp() {
        return aMH;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aMH = broadcastReceiver;
    }

    public static BroadcastReceiver Hq() {
        return aMI;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        aMI = broadcastReceiver;
    }
}
