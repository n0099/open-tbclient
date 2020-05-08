package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider efN;
    private static Service efV;
    private static BroadcastReceiver efW;
    private static BroadcastReceiver efX;

    public static Service aZS() {
        return efV;
    }

    public static ContentProvider aZP() {
        return efN;
    }

    public static BroadcastReceiver aZT() {
        return efW;
    }

    public static BroadcastReceiver aZU() {
        return efX;
    }
}
