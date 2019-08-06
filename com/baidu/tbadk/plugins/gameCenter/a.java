package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider cBO;
    private static Service cBW;
    private static BroadcastReceiver cBX;
    private static BroadcastReceiver cBY;

    public static Service avO() {
        return cBW;
    }

    public static ContentProvider avL() {
        return cBO;
    }

    public static BroadcastReceiver avP() {
        return cBX;
    }

    public static BroadcastReceiver avQ() {
        return cBY;
    }
}
