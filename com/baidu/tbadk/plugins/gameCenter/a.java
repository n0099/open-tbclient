package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static Service aVD;
    private static BroadcastReceiver aVE;
    private static BroadcastReceiver aVF;
    private static ContentProvider aVu;

    public static Service KX() {
        return aVD;
    }

    public static ContentProvider KV() {
        return aVu;
    }

    public static BroadcastReceiver KY() {
        return aVE;
    }

    public static BroadcastReceiver KZ() {
        return aVF;
    }
}
