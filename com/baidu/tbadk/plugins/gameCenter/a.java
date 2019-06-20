package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static BroadcastReceiver cAA;
    private static ContentProvider cAq;
    private static Service cAy;
    private static BroadcastReceiver cAz;

    public static Service auD() {
        return cAy;
    }

    public static ContentProvider auA() {
        return cAq;
    }

    public static BroadcastReceiver auE() {
        return cAz;
    }

    public static BroadcastReceiver auF() {
        return cAA;
    }
}
