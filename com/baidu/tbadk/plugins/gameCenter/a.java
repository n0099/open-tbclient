package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider cCK;
    private static Service cCS;
    private static BroadcastReceiver cCT;
    private static BroadcastReceiver cCU;

    public static Service awa() {
        return cCS;
    }

    public static ContentProvider avX() {
        return cCK;
    }

    public static BroadcastReceiver awb() {
        return cCT;
    }

    public static BroadcastReceiver awc() {
        return cCU;
    }
}
