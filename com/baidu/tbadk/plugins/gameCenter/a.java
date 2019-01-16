package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider bim;
    private static Service biu;
    private static BroadcastReceiver biv;
    private static BroadcastReceiver biw;

    public static Service PS() {
        return biu;
    }

    public static ContentProvider PQ() {
        return bim;
    }

    public static BroadcastReceiver PT() {
        return biv;
    }

    public static BroadcastReceiver PU() {
        return biw;
    }
}
