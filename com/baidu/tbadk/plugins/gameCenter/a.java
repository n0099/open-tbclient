package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider fJm;
    private static Service fJt;
    private static BroadcastReceiver fJu;
    private static BroadcastReceiver fJv;

    public static Service bEm() {
        return fJt;
    }

    public static ContentProvider bEj() {
        return fJm;
    }

    public static BroadcastReceiver bEn() {
        return fJu;
    }

    public static BroadcastReceiver bEo() {
        return fJv;
    }
}
