package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider fiT;
    private static Service fja;
    private static BroadcastReceiver fjb;
    private static BroadcastReceiver fjc;

    public static Service byw() {
        return fja;
    }

    public static ContentProvider byt() {
        return fiT;
    }

    public static BroadcastReceiver byx() {
        return fjb;
    }

    public static BroadcastReceiver byy() {
        return fjc;
    }
}
