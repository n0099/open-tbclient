package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service dFG;
    private static BroadcastReceiver dFH;
    private static BroadcastReceiver dFI;
    private static ContentProvider dFy;

    public static Service aRF() {
        return dFG;
    }

    public static ContentProvider aRC() {
        return dFy;
    }

    public static BroadcastReceiver aRG() {
        return dFH;
    }

    public static BroadcastReceiver aRH() {
        return dFI;
    }
}
