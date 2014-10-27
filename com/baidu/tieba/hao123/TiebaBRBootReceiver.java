package com.baidu.tieba.hao123;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.Hao123Plugin;
/* loaded from: classes.dex */
public class TiebaBRBootReceiver extends BroadcastReceiver {
    public static final String TAG = "TiebaBRBootReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Hao123Plugin hao123Plugin;
        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_HAO123);
        if (pluginByName != null && (hao123Plugin = (Hao123Plugin) pluginByName.getClassInstance(Hao123Plugin.class)) != null) {
            hao123Plugin.brBootOnReceiver(context, intent);
        }
    }
}
