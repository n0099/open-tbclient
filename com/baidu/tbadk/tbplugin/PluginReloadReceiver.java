package com.baidu.tbadk.tbplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class PluginReloadReceiver extends BroadcastReceiver {
    public static final String ACTION_PLUGIN_RELOAD = "com.baidu.tbadk.tbplugin.action.PLUGIN_RELOAD";
    private static final String TAG = "PluginReloadReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        m a;
        if (ACTION_PLUGIN_RELOAD.equals(intent.getAction()) && (a = m.a()) != null) {
            a.q();
        }
    }
}
