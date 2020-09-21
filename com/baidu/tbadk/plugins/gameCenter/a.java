package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider eWH;
    private static Service eWO;
    private static BroadcastReceiver eWP;
    private static BroadcastReceiver eWQ;

    public static Service bvM() {
        return eWO;
    }

    public static ContentProvider bvJ() {
        return eWH;
    }

    public static BroadcastReceiver bvN() {
        return eWP;
    }

    public static BroadcastReceiver bvO() {
        return eWQ;
    }
}
