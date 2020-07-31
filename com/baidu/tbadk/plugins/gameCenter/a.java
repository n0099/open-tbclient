package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider eJh;
    private static Service eJo;
    private static BroadcastReceiver eJp;
    private static BroadcastReceiver eJq;

    public static Service blU() {
        return eJo;
    }

    public static ContentProvider blR() {
        return eJh;
    }

    public static BroadcastReceiver blV() {
        return eJp;
    }

    public static BroadcastReceiver blW() {
        return eJq;
    }
}
