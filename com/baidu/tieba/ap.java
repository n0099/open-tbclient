package com.baidu.tieba;

import com.baidu.tbadk.pluginArch.InstallCallback;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.LivePlugin;
/* loaded from: classes.dex */
class ap implements InstallCallback {
    final /* synthetic */ ao aeg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.aeg = aoVar;
    }

    @Override // com.baidu.tbadk.pluginArch.InstallCallback
    public void onFinish(int i, String str) {
        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_LIVE);
        if (pluginByName != null) {
            pluginByName.getClassInstance(LivePlugin.class);
        }
    }
}
