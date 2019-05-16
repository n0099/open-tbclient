package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider cAp;
    private static Service cAx;
    private static BroadcastReceiver cAy;
    private static BroadcastReceiver cAz;

    public static Service auD() {
        return cAx;
    }

    public static ContentProvider auA() {
        return cAp;
    }

    public static BroadcastReceiver auE() {
        return cAy;
    }

    public static BroadcastReceiver auF() {
        return cAz;
    }
}
