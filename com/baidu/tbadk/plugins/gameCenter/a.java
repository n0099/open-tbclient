package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider csh;
    private static Service csp;
    private static BroadcastReceiver csq;
    private static BroadcastReceiver csr;

    public static Service apD() {
        return csp;
    }

    public static ContentProvider apA() {
        return csh;
    }

    public static BroadcastReceiver apE() {
        return csq;
    }

    public static BroadcastReceiver apF() {
        return csr;
    }
}
