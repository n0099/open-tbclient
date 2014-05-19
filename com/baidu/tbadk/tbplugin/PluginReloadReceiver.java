package com.baidu.tbadk.tbplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class PluginReloadReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("com.baidu.tbadk.tbplugin.action.PLUGIN_RELOAD".equals(intent.getAction())) {
            BdLog.d("on receiver PLUGIN_RELOAD action");
            m a = m.a();
            if (a != null) {
                BdLog.d("do reload");
                a.q();
            }
        }
    }
}
