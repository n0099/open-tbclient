package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider efI;
    private static Service efQ;
    private static BroadcastReceiver efR;
    private static BroadcastReceiver efS;

    public static Service aZU() {
        return efQ;
    }

    public static ContentProvider aZR() {
        return efI;
    }

    public static BroadcastReceiver aZV() {
        return efR;
    }

    public static BroadcastReceiver aZW() {
        return efS;
    }
}
