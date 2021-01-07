package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider fNT;
    private static Service fOa;
    private static BroadcastReceiver fOb;
    private static BroadcastReceiver fOc;

    public static Service bIe() {
        return fOa;
    }

    public static ContentProvider bIb() {
        return fNT;
    }

    public static BroadcastReceiver bIf() {
        return fOb;
    }

    public static BroadcastReceiver bIg() {
        return fOc;
    }
}
