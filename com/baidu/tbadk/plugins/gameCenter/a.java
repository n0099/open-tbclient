package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider dFL;
    private static Service dFT;
    private static BroadcastReceiver dFU;
    private static BroadcastReceiver dFV;

    public static Service aRG() {
        return dFT;
    }

    public static ContentProvider aRD() {
        return dFL;
    }

    public static BroadcastReceiver aRH() {
        return dFU;
    }

    public static BroadcastReceiver aRI() {
        return dFV;
    }
}
