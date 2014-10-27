package com.baidu.tieba;

import com.baidu.tbadk.pluginArch.InstallCallback;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.LivePlugin;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements InstallCallback {
    final /* synthetic */ aj adY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(aj ajVar) {
        this.adY = ajVar;
    }

    @Override // com.baidu.tbadk.pluginArch.InstallCallback
    public void onFinish(int i, String str) {
        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_LIVE);
        if (pluginByName != null) {
            pluginByName.getClassInstance(LivePlugin.class);
        }
    }
}
