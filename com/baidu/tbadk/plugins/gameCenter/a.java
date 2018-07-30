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

    public static Service KT() {
        return aVD;
    }

    public static ContentProvider KR() {
        return aVu;
    }

    public static BroadcastReceiver KU() {
        return aVE;
    }

    public static BroadcastReceiver KV() {
        return aVF;
    }
}
