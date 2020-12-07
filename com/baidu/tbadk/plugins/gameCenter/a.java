package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider fEo;
    private static Service fEv;
    private static BroadcastReceiver fEw;
    private static BroadcastReceiver fEx;

    public static Service bFI() {
        return fEv;
    }

    public static ContentProvider bFF() {
        return fEo;
    }

    public static BroadcastReceiver bFJ() {
        return fEw;
    }

    public static BroadcastReceiver bFK() {
        return fEx;
    }
}
