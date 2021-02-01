package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service fLE;
    private static BroadcastReceiver fLF;
    private static BroadcastReceiver fLG;
    private static ContentProvider fLx;

    public static Service bEE() {
        return fLE;
    }

    public static ContentProvider bEB() {
        return fLx;
    }

    public static BroadcastReceiver bEF() {
        return fLF;
    }

    public static BroadcastReceiver bEG() {
        return fLG;
    }
}
