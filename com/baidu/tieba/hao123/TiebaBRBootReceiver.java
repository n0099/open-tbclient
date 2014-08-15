package com.baidu.tieba.hao123;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.pluginArch.c;
import com.baidu.tbadk.pluginArch.d;
import com.baidu.tbadk.plugins.Hao123Plugin;
/* loaded from: classes.dex */
public class TiebaBRBootReceiver extends BroadcastReceiver {
    public static final String TAG = "TiebaBRBootReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Hao123Plugin hao123Plugin;
        c a = d.a().a("hao123");
        if (a != null && (hao123Plugin = (Hao123Plugin) a.a(Hao123Plugin.class)) != null) {
            hao123Plugin.brBootOnReceiver(context, intent);
        }
    }
}
