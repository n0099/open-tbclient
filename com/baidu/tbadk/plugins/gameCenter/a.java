package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider fMX;
    private static Service fNe;
    private static BroadcastReceiver fNf;
    private static BroadcastReceiver fNg;

    public static Service bEI() {
        return fNe;
    }

    public static ContentProvider bEF() {
        return fMX;
    }

    public static BroadcastReceiver bEJ() {
        return fNf;
    }

    public static BroadcastReceiver bEK() {
        return fNg;
    }
}
