package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider dBm;
    private static Service dBu;
    private static BroadcastReceiver dBv;
    private static BroadcastReceiver dBw;

    public static Service aOU() {
        return dBu;
    }

    public static ContentProvider aOR() {
        return dBm;
    }

    public static BroadcastReceiver aOV() {
        return dBv;
    }

    public static BroadcastReceiver aOW() {
        return dBw;
    }
}
