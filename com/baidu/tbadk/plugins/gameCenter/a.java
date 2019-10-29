package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider cNT;
    private static Service cOb;
    private static BroadcastReceiver cOc;
    private static BroadcastReceiver cOd;

    public static Service axf() {
        return cOb;
    }

    public static ContentProvider axc() {
        return cNT;
    }

    public static BroadcastReceiver axg() {
        return cOc;
    }

    public static BroadcastReceiver axh() {
        return cOd;
    }
}
