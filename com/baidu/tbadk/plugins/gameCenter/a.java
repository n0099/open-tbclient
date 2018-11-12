package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider bdW;
    private static Service bef;
    private static BroadcastReceiver beh;
    private static BroadcastReceiver bei;

    public static Service Ou() {
        return bef;
    }

    public static ContentProvider Os() {
        return bdW;
    }

    public static BroadcastReceiver Ov() {
        return beh;
    }

    public static BroadcastReceiver Ow() {
        return bei;
    }
}
