package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider aYJ;
    private static Service aYS;
    private static BroadcastReceiver aYT;
    private static BroadcastReceiver aYU;

    public static Service Mn() {
        return aYS;
    }

    public static ContentProvider Ml() {
        return aYJ;
    }

    public static BroadcastReceiver Mo() {
        return aYT;
    }

    public static BroadcastReceiver Mp() {
        return aYU;
    }
}
