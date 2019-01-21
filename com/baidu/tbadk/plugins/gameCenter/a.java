package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider bin;
    private static Service biv;
    private static BroadcastReceiver biw;
    private static BroadcastReceiver bix;

    public static Service PS() {
        return biv;
    }

    public static ContentProvider PQ() {
        return bin;
    }

    public static BroadcastReceiver PT() {
        return biw;
    }

    public static BroadcastReceiver PU() {
        return bix;
    }
}
