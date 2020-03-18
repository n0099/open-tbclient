package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider dGb;
    private static Service dGj;
    private static BroadcastReceiver dGk;
    private static BroadcastReceiver dGl;

    public static Service aRK() {
        return dGj;
    }

    public static ContentProvider aRH() {
        return dGb;
    }

    public static BroadcastReceiver aRL() {
        return dGk;
    }

    public static BroadcastReceiver aRM() {
        return dGl;
    }
}
