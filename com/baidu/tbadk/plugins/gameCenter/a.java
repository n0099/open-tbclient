package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider csj;
    private static Service css;
    private static BroadcastReceiver cst;
    private static BroadcastReceiver csu;

    public static Service apE() {
        return css;
    }

    public static ContentProvider apB() {
        return csj;
    }

    public static BroadcastReceiver apF() {
        return cst;
    }

    public static BroadcastReceiver apG() {
        return csu;
    }
}
