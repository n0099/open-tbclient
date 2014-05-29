package com.baidu.tieba.hao123;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.plugins.Hao123Plugin;
import com.baidu.tbadk.tbplugin.m;
/* loaded from: classes.dex */
public class TiebaBRBootReceiver extends BroadcastReceiver {
    public static final String TAG = "TiebaBRBootReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Hao123Plugin hao123Plugin = (Hao123Plugin) m.a().b(Hao123Plugin.class);
        if (hao123Plugin != null) {
            hao123Plugin.brBootOnReceiver(context, intent);
        }
    }
}
