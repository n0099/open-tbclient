package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider eTR;
    private static Service eTY;
    private static BroadcastReceiver eTZ;
    private static BroadcastReceiver eUa;

    public static Service buI() {
        return eTY;
    }

    public static ContentProvider buF() {
        return eTR;
    }

    public static BroadcastReceiver buJ() {
        return eTZ;
    }

    public static BroadcastReceiver buK() {
        return eUa;
    }
}
