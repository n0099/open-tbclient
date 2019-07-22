package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider cBH;
    private static Service cBP;
    private static BroadcastReceiver cBQ;
    private static BroadcastReceiver cBR;

    public static Service avM() {
        return cBP;
    }

    public static ContentProvider avJ() {
        return cBH;
    }

    public static BroadcastReceiver avN() {
        return cBQ;
    }

    public static BroadcastReceiver avO() {
        return cBR;
    }
}
