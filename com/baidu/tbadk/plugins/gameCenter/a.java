package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service dBE;
    private static BroadcastReceiver dBF;
    private static BroadcastReceiver dBG;
    private static ContentProvider dBw;

    public static Service aPn() {
        return dBE;
    }

    public static ContentProvider aPk() {
        return dBw;
    }

    public static BroadcastReceiver aPo() {
        return dBF;
    }

    public static BroadcastReceiver aPp() {
        return dBG;
    }
}
