package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider eub;
    private static Service euj;
    private static BroadcastReceiver euk;
    private static BroadcastReceiver eul;

    public static Service bgc() {
        return euj;
    }

    public static ContentProvider bfZ() {
        return eub;
    }

    public static BroadcastReceiver bgd() {
        return euk;
    }

    public static BroadcastReceiver bge() {
        return eul;
    }
}
