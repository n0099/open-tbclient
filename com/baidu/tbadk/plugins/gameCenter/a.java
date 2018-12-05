package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service bhG;
    private static BroadcastReceiver bhH;
    private static BroadcastReceiver bhI;
    private static ContentProvider bhx;

    public static Service Py() {
        return bhG;
    }

    public static ContentProvider Pw() {
        return bhx;
    }

    public static BroadcastReceiver Pz() {
        return bhH;
    }

    public static BroadcastReceiver PA() {
        return bhI;
    }
}
