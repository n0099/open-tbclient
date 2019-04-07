package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider csj;
    private static Service csr;
    private static BroadcastReceiver css;
    private static BroadcastReceiver cst;

    public static Service apA() {
        return csr;
    }

    public static ContentProvider apx() {
        return csj;
    }

    public static BroadcastReceiver apB() {
        return css;
    }

    public static BroadcastReceiver apC() {
        return cst;
    }
}
