package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider eCS;
    private static Service eCZ;
    private static BroadcastReceiver eDa;
    private static BroadcastReceiver eDb;

    public static Service bij() {
        return eCZ;
    }

    public static ContentProvider big() {
        return eCS;
    }

    public static BroadcastReceiver bik() {
        return eDa;
    }

    public static BroadcastReceiver bil() {
        return eDb;
    }
}
