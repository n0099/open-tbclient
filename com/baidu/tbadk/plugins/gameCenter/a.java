package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider csk;
    private static Service css;
    private static BroadcastReceiver cst;
    private static BroadcastReceiver csu;

    public static Service apA() {
        return css;
    }

    public static ContentProvider apx() {
        return csk;
    }

    public static BroadcastReceiver apB() {
        return cst;
    }

    public static BroadcastReceiver apC() {
        return csu;
    }
}
