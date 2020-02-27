package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service dFF;
    private static BroadcastReceiver dFG;
    private static BroadcastReceiver dFH;
    private static ContentProvider dFx;

    public static Service aRD() {
        return dFF;
    }

    public static ContentProvider aRA() {
        return dFx;
    }

    public static BroadcastReceiver aRE() {
        return dFG;
    }

    public static BroadcastReceiver aRF() {
        return dFH;
    }
}
