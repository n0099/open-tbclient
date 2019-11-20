package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider cNc;
    private static Service cNk;
    private static BroadcastReceiver cNl;
    private static BroadcastReceiver cNm;

    public static Service axd() {
        return cNk;
    }

    public static ContentProvider axa() {
        return cNc;
    }

    public static BroadcastReceiver axe() {
        return cNl;
    }

    public static BroadcastReceiver axf() {
        return cNm;
    }
}
