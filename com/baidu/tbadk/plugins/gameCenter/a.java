package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider bdj;
    private static Service bds;
    private static BroadcastReceiver bdt;
    private static BroadcastReceiver bdu;

    public static Service Ol() {
        return bds;
    }

    public static ContentProvider Oj() {
        return bdj;
    }

    public static BroadcastReceiver Om() {
        return bdt;
    }

    public static BroadcastReceiver On() {
        return bdu;
    }
}
