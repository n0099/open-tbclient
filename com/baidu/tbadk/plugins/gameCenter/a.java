package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider bhA;
    private static Service bhJ;
    private static BroadcastReceiver bhK;
    private static BroadcastReceiver bhL;

    public static Service PA() {
        return bhJ;
    }

    public static ContentProvider Py() {
        return bhA;
    }

    public static BroadcastReceiver PB() {
        return bhK;
    }

    public static BroadcastReceiver PC() {
        return bhL;
    }
}
