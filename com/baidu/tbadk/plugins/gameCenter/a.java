package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service fwG;
    private static BroadcastReceiver fwH;
    private static BroadcastReceiver fwI;
    private static ContentProvider fwz;

    public static Service bCh() {
        return fwG;
    }

    public static ContentProvider bCe() {
        return fwz;
    }

    public static BroadcastReceiver bCi() {
        return fwH;
    }

    public static BroadcastReceiver bCj() {
        return fwI;
    }
}
