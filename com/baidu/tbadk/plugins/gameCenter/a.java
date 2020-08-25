package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes2.dex */
public class a {
    private static ContentProvider eTN;
    private static Service eTU;
    private static BroadcastReceiver eTV;
    private static BroadcastReceiver eTW;

    public static Service buH() {
        return eTU;
    }

    public static ContentProvider buE() {
        return eTN;
    }

    public static BroadcastReceiver buI() {
        return eTV;
    }

    public static BroadcastReceiver buJ() {
        return eTW;
    }
}
