package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aVB;
    private static BroadcastReceiver aVC;
    private static BroadcastReceiver aVD;
    private static ContentProvider aVt;

    public static Service KY() {
        return aVB;
    }

    public static void a(Service service) {
        aVB = service;
    }

    public static ContentProvider KW() {
        return aVt;
    }

    public static void a(ContentProvider contentProvider) {
        aVt = contentProvider;
    }

    public static BroadcastReceiver KZ() {
        return aVC;
    }

    public static void b(BroadcastReceiver broadcastReceiver) {
        aVC = broadcastReceiver;
    }

    public static BroadcastReceiver La() {
        return aVD;
    }

    public static void c(BroadcastReceiver broadcastReceiver) {
        aVD = broadcastReceiver;
    }
}
