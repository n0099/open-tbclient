package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider fxk;
    private static Service fxr;
    private static BroadcastReceiver fxs;
    private static BroadcastReceiver fxt;

    public static Service bCO() {
        return fxr;
    }

    public static ContentProvider bCL() {
        return fxk;
    }

    public static BroadcastReceiver bCP() {
        return fxs;
    }

    public static BroadcastReceiver bCQ() {
        return fxt;
    }
}
