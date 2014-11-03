package com.baidu.tieba;

import com.baidu.tbadk.pluginArch.InstallCallback;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.RandChatPlugin;
/* loaded from: classes.dex */
class am implements InstallCallback {
    final /* synthetic */ al aef;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar) {
        this.aef = alVar;
    }

    @Override // com.baidu.tbadk.pluginArch.InstallCallback
    public void onFinish(int i, String str) {
        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_RANDCHAT);
        if (pluginByName != null) {
            pluginByName.getClassInstance(RandChatPlugin.class);
        }
    }
}
